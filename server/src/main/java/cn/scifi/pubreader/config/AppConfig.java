package cn.scifi.pubreader.config;

import cn.scifi.pubreader.config.properties.AppProperties;
import cn.scifi.pubreader.infrastructure.common.constants.CodedEnum;
import cn.scifi.pubreader.infrastructure.common.constants.Constant;
import cn.scifi.pubreader.infrastructure.common.serialize.CodedEnumConverterFactory;
import cn.scifi.pubreader.infrastructure.common.serialize.ToEnumCodeSerializer;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.undertow.server.DefaultByteBufferPool;
import io.undertow.websockets.jsr.WebSocketDeploymentInfo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final AppProperties appProperties;

    @Bean
    public WebServerFactoryCustomizer<UndertowServletWebServerFactory> webServerFactoryCustomizer() {
        return (UndertowServletWebServerFactory factory) -> factory.addDeploymentInfoCustomizers(deploymentInfo -> {
            WebSocketDeploymentInfo info = new WebSocketDeploymentInfo();
            info.setBuffers(new DefaultByteBufferPool(true, 1024));
            deploymentInfo.addServletContextAttribute("io.undertow.websockets.jsr.WebSocketDeploymentInfo", info);
        });
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        if (appProperties.getAllowOrigins().isEmpty()) {
            config.addAllowedOrigin("*");
        } else {
            for (String allowOrigin : appProperties.getAllowOrigins()) {
                config.addAllowedOrigin(allowOrigin);
            }
            config.setAllowCredentials(true);
        }
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", config);
        return new CorsFilter(configurationSource);
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilder() {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder
                .serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(Constant.DATETIME_FORMAT)))
                .deserializers(new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(Constant.DATETIME_FORMAT)))
                .serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(Constant.DATE_FORMAT)))
                .deserializers(new LocalDateDeserializer(DateTimeFormatter.ofPattern(Constant.DATE_FORMAT)))
                .serializerByType(CodedEnum.class, ToEnumCodeSerializer.instance)
                .serializerByType(Long.class, ToStringSerializer.instance)
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                LocalDateTime now = LocalDateTime.now();

                this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, now);
                this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, now);
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
            }
        };
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(@NonNull PathMatchConfigurer configurer) {
                configurer.addPathPrefix(appProperties.getApiPrefix(), cls -> cls.isAnnotationPresent(RestController.class));
            }
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverterFactory(new CodedEnumConverterFactory());
            }
        };
    }

}
package cn.scifi.novelogic.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;


/**
 * default url: /swagger-ui.html
 * reset url: /swagger-ui/index.html
 *
 * @author Bing D. Yee
 * @since 2024/03/08
 */
@Configuration
@OpenAPIDefinition(info = @Info(
        title = "[CNSF] Novel Logic 1.0 REST API",
        version = "1.0.0",
        description = "[About Me] SF writer｜Software Engineer and Creative Commons advocate."
), security = {
        @SecurityRequirement(name = OpenApiConfig.BEARER_TOKEN_KEY)
})
@SecurityScheme(
        name = OpenApiConfig.BEARER_TOKEN_KEY,
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {

    public static final String BEARER_TOKEN_KEY = "BearerToken";

}

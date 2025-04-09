package cn.scifi.pubreader.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    /** 接口前缀 */
    private String apiPrefix;

    /** 白名单 */
    private List<String> allowlist;

    /** cors 跨域 */
    private List<String> allowOrigins;

}

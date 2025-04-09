package cn.scifi.pubreader.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author bingdyee
 * @since 2024/9/27
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.rsa")
public class RsaProperties {

    private RSAPublicKey publicKey;

    private RSAPrivateKey privateKey;

    private Integer expiresIn;

}

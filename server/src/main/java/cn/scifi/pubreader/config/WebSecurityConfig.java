package cn.scifi.pubreader.config;

import cn.scifi.pubreader.config.properties.AppProperties;
import cn.scifi.pubreader.infrastructure.common.security.AccessAuthenticationEntryPoint;
import cn.scifi.pubreader.infrastructure.common.security.AccessForbiddenHandler;
import cn.scifi.pubreader.infrastructure.common.security.Base64AuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final AppProperties appProperties;
//    private final RsaProperties rsaProperties;
    private final UserDetailsService userDetailsService;
//    private final HandlerExceptionResolver handlerExceptionResolver;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        String[] whitelist = appProperties.getAllowlist().toArray(new String[0]);
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(whitelist).permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling((exceptions) -> exceptions
                        .authenticationEntryPoint(new AccessAuthenticationEntryPoint())
                        .accessDeniedHandler(new AccessForbiddenHandler())
                )
                .httpBasic(Customizer.withDefaults());
        Base64AuthenticationFilter base64AuthenticationFilter = new Base64AuthenticationFilter();
        http.addFilterBefore(base64AuthenticationFilter, AbstractPreAuthenticatedProcessingFilter.class);
        return http.build();
    }

    @Bean
    AuthenticationManager authManager() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(authProvider);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

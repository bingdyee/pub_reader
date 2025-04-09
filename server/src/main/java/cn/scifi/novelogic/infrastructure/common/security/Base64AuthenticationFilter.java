package cn.scifi.novelogic.infrastructure.common.security;

import cn.scifi.novelogic.infrastructure.common.utils.Strings;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author bingdyee
 * @since 2024/9/28
 */
@RequiredArgsConstructor
public class Base64AuthenticationFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(Base64AuthenticationFilter.class);

    public static final String TOKEN_PARAM_KEY = "token";

    public final static String TICKET_HEADER_KEY = "X-USER-TICKET";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = extractAccessToken(request);
            if (Strings.isNotBlank(token)) {
                byte[] decode = Base64.getDecoder().decode(token);
                String tokenPlain = new String(decode, StandardCharsets.UTF_8);
                String[] splits = tokenPlain.split(":");
                UserPrincipal principal = new UserPrincipal(Long.parseLong(splits[0]), splits[1], splits[2]);
                Authentication authentication = new PreAuthenticatedAuthenticationToken(principal, null, principal.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            SecurityContextHolder.clearContext();
            logger.error("Authentication request failed: {}", e.getMessage());
        }
        filterChain.doFilter(request, response);
    }

    public static String extractAccessToken(HttpServletRequest request) {
        String accessTokenValue = request.getParameter(TOKEN_PARAM_KEY);
        if (Strings.isBlank(accessTokenValue)) {
            String value = request.getHeader(TICKET_HEADER_KEY);
            if (Strings.isNotBlank(value)) {
                accessTokenValue = value.trim();
            }
        }
        return accessTokenValue;
    }

}

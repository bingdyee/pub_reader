package cn.scifi.pubreader.infrastructure.common.security;


import cn.scifi.pubreader.infrastructure.common.web.ApiResponse;
import cn.scifi.pubreader.infrastructure.common.constants.enums.StatusCode;
import cn.scifi.pubreader.infrastructure.common.utils.Jsons;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

/**
 * 访问限制
 *
 * @author yubinbin
 * @since 2022/03/01
 */
public class AccessAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException exception) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(Jsons.toJson(ApiResponse.of(StatusCode.UN_AUTH)));
    }

}
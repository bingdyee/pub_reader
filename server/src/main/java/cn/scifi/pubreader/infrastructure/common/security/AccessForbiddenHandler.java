package cn.scifi.pubreader.infrastructure.common.security;

import cn.scifi.pubreader.infrastructure.common.web.ApiResponse;
import cn.scifi.pubreader.infrastructure.common.constants.enums.StatusCode;
import cn.scifi.pubreader.infrastructure.common.utils.Jsons;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class AccessForbiddenHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String body = Jsons.toJson(ApiResponse.of(StatusCode.FORBIDDEN));
        response.getWriter().write(body);
    }

}
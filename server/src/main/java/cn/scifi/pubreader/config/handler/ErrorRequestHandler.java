package cn.scifi.pubreader.config.handler;

import cn.scifi.pubreader.infrastructure.common.web.ApiResponse;
import cn.scifi.pubreader.infrastructure.common.constants.enums.StatusCode;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author bingdyee
 * @since 2022/03/11
 */
@Hidden
@RestController
public class ErrorRequestHandler extends AbstractErrorController {

    public ErrorRequestHandler(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @GetMapping("${server.error.path:/error}")
    public ApiResponse<String> error(HttpServletRequest request) {
        Map<String, Object> errorAttributes = getErrorAttributes(request, ErrorAttributeOptions.defaults());
        return ApiResponse.of(StatusCode.INVALID_REQUEST.getCode(), errorAttributes.get("error").toString());
    }

}

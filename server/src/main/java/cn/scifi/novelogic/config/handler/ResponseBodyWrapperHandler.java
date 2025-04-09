package cn.scifi.novelogic.config.handler;

import cn.scifi.novelogic.infrastructure.common.web.ApiResponse;
import cn.scifi.novelogic.infrastructure.common.web.IgnoreResponseWrapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一接口返回数据结构
 *
 * @author Bing D. Yee
 * @since 2022/01/12
 */
@RestControllerAdvice("cn.scifi.novelogic")
public class ResponseBodyWrapperHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return AbstractJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        IgnoreResponseWrapper ignoreResponseWrapper = returnType.getMethodAnnotation(IgnoreResponseWrapper.class);
        return body instanceof ApiResponse || ignoreResponseWrapper != null ? body : ApiResponse.ok(body);
    }

}

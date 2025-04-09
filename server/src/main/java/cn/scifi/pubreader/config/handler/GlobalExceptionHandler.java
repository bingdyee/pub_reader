package cn.scifi.pubreader.config.handler;

import cn.scifi.pubreader.infrastructure.common.web.ApiResponse;
import cn.scifi.pubreader.infrastructure.common.constants.enums.StatusCode;
import cn.scifi.pubreader.infrastructure.common.exception.AbstractException;
import cn.scifi.pubreader.infrastructure.common.utils.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 *
 * @author Bing D. Yee
 * @since 2022/01/12
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ApiResponse<String> handleError(NoHandlerFoundException e) {
        log.error(StatusCode.NOT_FOUND.getDesc(), e);
        return ApiResponse.of(StatusCode.NOT_FOUND);
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            HttpMessageNotReadableException.class,
            MissingServletRequestParameterException.class,
            MethodArgumentTypeMismatchException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            NoResourceFoundException.class
    })
    @ResponseStatus(code = HttpStatus.OK)
    public ApiResponse<String> handleInvalidArgumentException(Exception e) {
        log.error("客户端请求错误：{}", e.getMessage());
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException)e).getBindingResult();
            Set<String> errors = bindingResult
                    .getFieldErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toSet());
            return ApiResponse.of(StatusCode.INVALID_REQUEST.getCode(), Strings.join(errors, ", "));
        }
        if (e instanceof HttpRequestMethodNotSupportedException) {
            return ApiResponse.of(StatusCode.INVALID_REQUEST.getCode(), "请求方式不支持");
        }
        if (e instanceof NoResourceFoundException) {
            return ApiResponse.of(StatusCode.NOT_FOUND);
        }
        return ApiResponse.of(StatusCode.INVALID_REQUEST);
    }

    @ExceptionHandler(AbstractException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ApiResponse<String> handleException(AbstractException e) {
        log.error("业务执行异常：", e);
        return ApiResponse.of(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ApiResponse<String> handleException(Exception e) {
        log.error("未知异常：", e);
        if (e.getCause() instanceof AbstractException exception) {
            return ApiResponse.of(exception.getErrorCode(), exception.getMessage());
        }
        return ApiResponse.of(StatusCode.INTERNAL_SERVER_ERROR);
    }

}

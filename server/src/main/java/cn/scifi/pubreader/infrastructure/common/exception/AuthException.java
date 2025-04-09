package cn.scifi.pubreader.infrastructure.common.exception;

import cn.scifi.pubreader.infrastructure.common.constants.enums.StatusCode;

/**
 * @author bingdyee
 * @since 2024/9/27
 */
public class AuthException extends AbstractException {
    public AuthException() {
        super(StatusCode.LOGIN_FAILED);
    }
    public AuthException(String message) {
        super(StatusCode.LOGIN_FAILED.getCode(), message);
    }

}

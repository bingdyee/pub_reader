package cn.scifi.pubreader.infrastructure.common.exception;

import cn.scifi.pubreader.infrastructure.common.constants.enums.StatusCode;

/**
 * @author bingdyee
 * @since 2024/9/27
 */
public class InvalidJwtException extends AbstractException {

    public InvalidJwtException(StatusCode code) {
        super(code);
    }

}

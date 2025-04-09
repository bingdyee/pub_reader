package cn.scifi.novelogic.infrastructure.common.exception;

import cn.scifi.novelogic.infrastructure.common.constants.enums.StatusCode;

/**
 * @author bingdyee
 * @since 2024/9/27
 */
public class InvalidJwtException extends AbstractException {

    public InvalidJwtException(StatusCode code) {
        super(code);
    }

}

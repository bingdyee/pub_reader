package cn.scifi.novelogic.infrastructure.common.exception;

import cn.scifi.novelogic.infrastructure.common.constants.enums.StatusCode;

/**
 * @author bingdyee
 * @since 2024/9/9
 */
public class UnsupportedEnumCodeException extends AbstractException {

    public UnsupportedEnumCodeException() {
        super(StatusCode.UNSUPPORTED_ENUM_CODE);
    }

    public UnsupportedEnumCodeException(String message) {
        super(StatusCode.UNSUPPORTED_ENUM_CODE.getCode(), message);
    }

}

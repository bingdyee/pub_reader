package cn.scifi.pubreader.infrastructure.common.exception;

import cn.scifi.pubreader.infrastructure.common.constants.StatusInfo;
import cn.scifi.pubreader.infrastructure.common.constants.enums.StatusCode;

public class AbstractException extends RuntimeException {

    private static final long serialVersionUID = -6228610265769822498L;

    protected int errorCode;

    public AbstractException(String message) {
        this(StatusCode.INTERNAL_SERVER_ERROR.getCode(), message);
    }

    public AbstractException(StatusInfo errorStatus) {
        this(errorStatus.getCode(), errorStatus.getDesc());
    }

    public AbstractException(int errorCode, String errorDesc) {
        super(errorDesc);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

}
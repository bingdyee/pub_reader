package cn.scifi.pubreader.infrastructure.common.exception;

import cn.scifi.pubreader.infrastructure.common.constants.StatusInfo;
import cn.scifi.pubreader.infrastructure.common.constants.enums.StatusCode;

public class BizExecException extends AbstractException {

    private static final long serialVersionUID = -7032134959304939397L;

    public BizExecException(String message) {
        super(StatusCode.BUSINESS_ERROR.getCode(), message);
    }

    public BizExecException(StatusInfo errorStatus) {
        super(errorStatus);
    }

    public BizExecException(int errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }

}

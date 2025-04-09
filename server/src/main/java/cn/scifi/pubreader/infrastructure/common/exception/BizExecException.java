package cn.scifi.novelogic.infrastructure.common.exception;

import cn.scifi.novelogic.infrastructure.common.constants.StatusInfo;
import cn.scifi.novelogic.infrastructure.common.constants.enums.StatusCode;

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

package cn.scifi.pubreader.infrastructure.common.exception;

import cn.scifi.pubreader.infrastructure.common.constants.enums.StatusCode;

/**
 * @author bingdyee
 * @since 2024/9/28
 */
public class NotFoundException extends AbstractException {

    public NotFoundException() {
        super(StatusCode.NOT_FOUND);
    }

}

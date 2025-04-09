package cn.scifi.novelogic.infrastructure.common.exception;

import cn.scifi.novelogic.infrastructure.common.constants.enums.StatusCode;

/**
 * @author bingdyee
 * @since 2024/9/28
 */
public class NotFoundException extends AbstractException {

    public NotFoundException() {
        super(StatusCode.NOT_FOUND);
    }

}

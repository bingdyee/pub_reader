package cn.scifi.pubreader.infrastructure.common.constants.enums;

import cn.scifi.pubreader.infrastructure.common.constants.CodedEnum;

/**
 *
 * 状态：1-正常；2-封禁；3-注销
 *
 * @author bingdyee
 * @since 2024/9/27
 */
public enum UserStatus implements CodedEnum {
    NORMAL(1),
    BANNED(2),
    CLOSED(3);

    private final int code;

    UserStatus(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }

}

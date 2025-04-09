package cn.scifi.novelogic.infrastructure.common.constants.enums;

import cn.scifi.novelogic.infrastructure.common.constants.CodedEnum;
import lombok.Getter;

/**
 * @author bingdyee
 * @since 2024/9/26
 */
@Getter
public enum Gender implements CodedEnum {
    // 男
    MALE(1),
    // 女
    FEMALE(2);

    private final int code;

    Gender(int code) {
        this.code = code;
    }

}

package cn.scifi.pubreader.domain.model.valobj;

import cn.scifi.pubreader.infrastructure.common.constants.CodedEnum;
import lombok.Getter;

/**
 * @author bingdyee
 * @since 2024/9/9
 */
@Getter
public enum BookOrderType implements CodedEnum {
    /** 最热 */
    HOTTEST(1, "read_count"),
    /** 最新 */
    NEWEST(2, "last_chapter_update_time"),
    /** 字数 */
    WORD_COUNT(3, "word_count");

    private final int code;
    // 排序字段
    private final String orderField;

    BookOrderType(int code, String name) {
        this.orderField = name;
        this.code = code;
    }

}

package cn.scifi.novelogic.domain.model.valobj;

import cn.scifi.novelogic.infrastructure.common.constants.CodedEnum;
import lombok.Getter;

/**
 * @author bingdyee
 * @since 2024/9/9
 */
@Getter
public enum BookUpdateRange implements CodedEnum {
    /** 三天内 */
    THREE_DAY(1, 3),
    /** 七天内 */
    ONE_WEEK(2, 7),
    /** 半月内 */
    HALF_MONTH(3, 15),
    /** 一月内 */
    ONE_MONTH(4, 30);

    private final int code;

    private final Integer days;

    BookUpdateRange(int code, int name) {
        this.days = name;
        this.code = code;
    }

}

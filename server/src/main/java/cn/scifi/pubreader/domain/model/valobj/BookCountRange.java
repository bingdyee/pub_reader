package cn.scifi.pubreader.domain.model.valobj;

import cn.scifi.pubreader.infrastructure.common.constants.CodedEnum;
import lombok.Getter;

/**
 * 字数范围
 *
 * @author bingdyee
 * @since 2024/9/9
 */
@Getter
public enum BookCountRange implements CodedEnum {
    COUNT_1(1, null, 300000,"30万字以下"),
    COUNT_2(2, 300000, 500000,"30-50万字"),
    COUNT_3(3, 500000, 1000000,"50-100万字"),
    COUNT_4(4, 1000000, 2000000,"100-200万字"),
    COUNT_5(5, 2000000, null,"200万字以上");

    private final int code;
    private final String name;
    private final Integer from;
    private final Integer to;

    BookCountRange(int code, Integer from, Integer to, String name) {
        this.name = name;
        this.code = code;
        this.from = from;
        this.to = to;
    }

}

package cn.scifi.novelogic.domain.model.valobj;

import cn.scifi.novelogic.infrastructure.common.constants.CodedEnum;
import lombok.Getter;

/**
 * 小说频道
 *
 * @author bingdyee
 * @since 2024/9/8
 */
@Getter
public enum Channel implements CodedEnum {
    MALE(1, "男频"),
    FEMALE(2, "女频"),
    PRESS(3, "出版");

    private final int code;

    private final String name;

    Channel(int code, String name) {
        this.name = name;
        this.code = code;
    }

    public static Channel codeOf(int code) {
        for (Channel channel : Channel.values()) {
            if (channel.code == code) {
                return channel;
            }
        }
        return null;
    }

}

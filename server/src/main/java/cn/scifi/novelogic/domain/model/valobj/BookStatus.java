package cn.scifi.novelogic.domain.model.valobj;


import cn.scifi.novelogic.infrastructure.common.constants.CodedEnum;
import cn.scifi.novelogic.infrastructure.common.exception.UnsupportedEnumCodeException;
import lombok.Getter;

@Getter
public enum BookStatus implements CodedEnum {
    Ongoing(1, " 连载中"),
    Completed(2, "已完结");

    private final int code;

    private final String name;

    BookStatus(int code, String name) {
        this.name = name;
        this.code = code;
    }


    public static BookStatus codeOf(int code) {
        for (BookStatus drinkStatus : BookStatus.values()) {
            if (code == drinkStatus.getCode()) {
                return drinkStatus;
            }
        }
        throw new UnsupportedEnumCodeException();
    }


}

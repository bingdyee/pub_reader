package cn.scifi.pubreader.infrastructure.common.constants;


import cn.scifi.pubreader.infrastructure.common.exception.UnsupportedEnumCodeException;

/**
 * @author bingdyee
 * @since 2024/9/9
 */
public interface CodedEnum {

    /**
     * 编码
     *
     * @return 编码
     */
    int getCode();

    static<T extends CodedEnum> T codeOf(Class<T> enumType, int code) {
        T[] enums = enumType.getEnumConstants();
        for (T anEnum : enums) {
            if (anEnum.getCode() == code) {
                return anEnum;
            }
        }
        throw new UnsupportedEnumCodeException();
    }

}

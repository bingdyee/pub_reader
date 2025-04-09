package cn.scifi.novelogic.infrastructure.common.serialize;

import cn.scifi.novelogic.infrastructure.common.constants.CodedEnum;
import org.springframework.core.convert.converter.Converter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bingdyee
 * @since 2024/9/9
 */
public class NumberToEnumConverter<T extends CodedEnum> implements Converter<String, T> {

    private final Map<String, T> enumMap = new HashMap<>();

    NumberToEnumConverter(Class<T> enumType){
        T[] enums = enumType.getEnumConstants();
        for (T e : enums){
            enumMap.put(e.getCode() + "", e);
            enumMap.put(((Enum)e).name(), e);
        }
    }

    @Override
    public T convert(String source) {
        T result = enumMap.get(source);
        if(result == null){
            throw new IllegalArgumentException("No element matches " + source);
        }
        System.err.println(enumMap);
        return result;
    }

}

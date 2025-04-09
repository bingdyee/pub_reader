package cn.scifi.novelogic.infrastructure.common.serialize;

import cn.scifi.novelogic.infrastructure.common.constants.CodedEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bingdyee
 * @since 2024/9/9
 */
public class CodedEnumConverterFactory implements ConverterFactory<String, CodedEnum> {

    /**
     * 目标类型与对应转换器的Map
     */
    private static final Map<Class<?>, Converter<String, ?>> CONVERTER_MAP = new HashMap<>();

    /**
     * 根据目标类型获取相应的转换器
     *
     * @param targetType 目标类型
     * @param <T> CodedEnum的实现类
     * @return converter
     */
    @Override
    public <T extends CodedEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter<String, ?> converter = CONVERTER_MAP.get(targetType);
        if (converter == null) {
            converter = new NumberToEnumConverter<>(targetType);
            CONVERTER_MAP.put(targetType, converter);
        }
        return (Converter<String, T>) converter;
    }


}

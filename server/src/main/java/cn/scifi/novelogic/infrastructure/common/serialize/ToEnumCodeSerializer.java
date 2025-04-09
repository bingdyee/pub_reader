package cn.scifi.novelogic.infrastructure.common.serialize;

import cn.scifi.novelogic.infrastructure.common.constants.CodedEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * @author bingdyee
 * @since 2024/9/9
 */
public class ToEnumCodeSerializer extends StdSerializer<CodedEnum> {

    public static final ToEnumCodeSerializer instance = new ToEnumCodeSerializer(CodedEnum.class);

    public ToEnumCodeSerializer(Class<CodedEnum> handledType) {
        super(handledType, false);
    }

    @Override
    public void serialize(CodedEnum codedEnum, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        gen.writeNumber(codedEnum.getCode());
    }

}

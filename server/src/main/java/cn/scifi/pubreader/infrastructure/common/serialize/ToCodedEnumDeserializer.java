package cn.scifi.novelogic.infrastructure.common.serialize;

import cn.scifi.novelogic.infrastructure.common.constants.CodedEnum;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * @author bingdyee
 * @since 2024/10/21
 */
public class ToCodedEnumDeserializer<T extends CodedEnum> extends StdDeserializer<T> {

    public ToCodedEnumDeserializer() {
        super(Integer.class);
    }

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonToken t = jsonParser.currentToken();
        if (t == JsonToken.VALUE_STRING || t == JsonToken.VALUE_EMBEDDED_OBJECT) {
            int intValue = jsonParser.getIntValue();
            TypeReference<T> typeReference = new TypeReference<>() {};
        }
        return null;
    }

}

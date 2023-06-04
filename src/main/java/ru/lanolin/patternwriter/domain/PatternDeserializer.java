package ru.lanolin.patternwriter.domain;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ru.lanolin.patternwriter.util.Utils;

import java.io.IOException;

public class PatternDeserializer extends JsonDeserializer<Pattern> {

    @Override
    public Pattern deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String value = p.getCodec().readValue(p, String.class);
        if(value == null || value.isEmpty()) { return null; }
        return Utils.patternFromFlatString(value);
    }
}

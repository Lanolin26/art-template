package ru.lanolin.patternwriter.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import ru.lanolin.patternwriter.util.Utils;

import java.io.IOException;

public class PatternSerializer extends JsonSerializer<Pattern> {

    @Override
    public void serialize(Pattern value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(Utils.patternToFlatString(value));
    }
}

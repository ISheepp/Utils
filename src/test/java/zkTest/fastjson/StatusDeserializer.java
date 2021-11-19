package zkTest.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Type;

/**
 * @author 林子洋
 * @create 2021-11-19 16:31:01
 */
public class StatusDeserializer implements ObjectDeserializer {

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        JSONLexer lexer = parser.getLexer();
        int value = lexer.intValue();
        return (T) Status.create(value);
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}

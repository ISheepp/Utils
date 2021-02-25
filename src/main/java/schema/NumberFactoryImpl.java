package schema;

import java.math.BigDecimal;

/**
 * @author linzy
 * @create 2021-02-25 22:48:16
 */
public class NumberFactoryImpl implements NumberFactory {

    @Override
    public Number parse(String s) {
        return new BigDecimal(s);
    }
}

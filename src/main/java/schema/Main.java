package schema;

import org.junit.Test;

import java.time.LocalDate;


/**
 * @author linzy
 * @create 2021-02-25 22:52:29
 */
public class Main {

    @Test
    public void testFactory(){
        // 真正的工厂：NumberFactoryImpl
        // 真正的产品：BigDecimal
        NumberFactory factory = NumberFactory.getFactory();
        Number parse = factory.parse("22.123");
        System.out.println(parse);
    }

    @Test
    public void testFactory1(){
        System.err.println(LocalDateFactory.fromInt(20120202));
    }

}

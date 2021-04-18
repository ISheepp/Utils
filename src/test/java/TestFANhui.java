import entity.Func;
import entity.Student;
import org.junit.Test;

/**
 * @author linzy
 * @create 2020-12-25 15:18:43
 */

public class TestFANhui {

    @Test
    public void test(){

        new Func() {
            @Override
            public void print() {
                System.out.println("hhhh");
            }

            @Override
            public String s() {
                return null;
            }
        }.print();

        Func c = new Func() {
            @Override
            public void print() {

            }

            @Override
            public String s() {
                return null;
            }
        };
        String s = c.s();
        System.out.println(s);
    }

}

package func;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author linzy
 * @create 2021-04-21 10:33:10
 */
public class Fmain {

    @Test
    public void test(){
        Formula formula1 = a -> a * 100;
        Formula formula = a -> a * 100;
        double calculate = formula.calculate(100);
        System.out.println(calculate);
        System.out.println(formula.sqrt(100));
    }

    @Test
    public void test2(){
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                // 使用了default方法，lambda表达式不能使用
                return sqrt(a);
            }
        };
    }


}

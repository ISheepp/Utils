package juc.function;

import java.util.function.Supplier;

/**
 * @author linzy
 * @create 2021-03-03 22:55:10
 * 没有参数，只有返回值
 */
public class Demo4 {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "null";
        System.out.println(supplier.get());
    }
}

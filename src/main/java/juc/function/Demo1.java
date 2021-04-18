package juc.function;

import java.util.function.Function;

/**
 * @author linzy
 * @create 2021-03-03 22:35:54
 * Function<T, R> 传T返回R
 */
public class Demo1 {
    public static void main(String[] args) {
        // Function<T, R> 传T返回R
        Function<String, String> function = (str) -> str;
        System.out.println(function.apply("123"));
    }

}

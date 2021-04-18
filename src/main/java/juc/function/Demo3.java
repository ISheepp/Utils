package juc.function;

import java.util.function.Consumer;

/**
 * @author linzy
 * @create 2021-03-03 22:52:22
 * 消费：只有输入 ，没有返回值
 */
public class Demo3 {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;

        consumer.accept("asd");
    }
}

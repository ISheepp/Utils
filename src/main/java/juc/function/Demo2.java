package juc.function;

import java.util.function.Predicate;

/**
 * @author linzy
 * @create 2021-03-03 22:45:59
 * 断定型接口：有一个输入参数，返回值只能是布尔值！
 */
public class Demo2 {
    public static void main(String[] args) {
        // 判断字符串是否为空
        Predicate<String> predicate = String::isEmpty;

        System.out.println(predicate.test(""));
    }

}

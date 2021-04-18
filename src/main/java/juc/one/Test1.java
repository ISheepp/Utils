package juc.one;

/**
 * @author linzy
 * @create 2021-02-28 20:20:19
 */
public class Test1 {

    public static void main(String[] args) {
        // cpu密集型，io密集型
        // 获取cpu核心数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}

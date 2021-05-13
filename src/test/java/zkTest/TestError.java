package zkTest;

/**
 * @author 林子洋靓
 * @create 2021-05-08 10:48:26
 */
public class TestError {

    public static void main(String[] args) {
        try {
            System.out.println("main");
            ThreadLocal<Integer> i = new ThreadLocal<>();
            throwLzy();
            throw new Exception("main方法的error");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("2222");
        }
    }

    public static void throwLzy() {
        try {
            System.out.println("123");
            throw new Exception("第一个throw");
        } catch (Exception e) {
            System.out.println("捕捉到了第一个throw error");
        }
    }

}

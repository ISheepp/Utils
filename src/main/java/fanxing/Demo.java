package fanxing;

/**
 * @author lin
 * @create 2021-07-18 21:14:21
 */

public class Demo {
    public static void main(String[] args) {
        Fruit<String> fruit = new Fruit<>();
        fruit.print("sss");
        fruit.print2(1);
    }
}


class Fruit<T> {

    /**
     * 只能使用new对象时的泛型类型
     *
     * @param t t
     */
    public void print(T t) {
        System.out.println(t);
    }

    /**
     * 方法参数类型不受对象参数泛型类型限制，这样定义的话这个方法是可以传入任意类型的参数的
     *
     * @param q q
     * @param <Q> 泛型
     */
    public <Q> void print2(Q q) {
        System.out.println(q);
    }

}

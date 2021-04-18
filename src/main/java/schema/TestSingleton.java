package schema;

/**
 * @author linzy
 * @create 2021-02-25 21:33:25
 * 单例模式的目的
 * 保证在一个进程中，某个类有且仅有一个实例
 */

public class TestSingleton {

    // 静态字段引用唯一实例
    private static final TestSingleton INSTANCE = new TestSingleton();

    // 直接调用静态方法返回实例
    public static TestSingleton getInstance() {
        return INSTANCE;
    }

    // private构造方法保证外部无法实例化
    private TestSingleton() {

    }

}

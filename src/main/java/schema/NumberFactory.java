package schema;

/**
 * @author linzy
 * @create 2021-02-25 22:46:55
 */
public interface NumberFactory {

    // 创建方法
    Number parse(String s);

    // 获取工厂实例
    static NumberFactory getFactory() {
        return impl;
    }

    static NumberFactory impl = new NumberFactoryImpl();

}

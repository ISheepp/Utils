package schema.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author linzy
 * @create 2021-02-27 12:14:02
 */
public class UserProxyFactory {

    private Object target;

    public UserProxyFactory(Object target) {
        this.target = target;
    }

    // 生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("开启事务");
                    // 执行目标对象方法
                    Object returnValue = method.invoke(target, args);
                    System.out.println("提交事务");
                    return null;
                });
    }

}

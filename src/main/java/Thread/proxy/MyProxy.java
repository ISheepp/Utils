package Thread.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author linzy
 * @create 2021-03-17 11:59:40
 */
public class MyProxy {
    public static void main(String[] args) {
        Number factory = (Number) ProxyFactory.getFactory(new NumberImpl());
        factory.print();
    }
}

interface Number {

    void print();

}

class NumberImpl implements Number {
    @Override
    public void print() {
        System.out.println("hahaha");
    }
}

class ProxyLzy implements InvocationHandler {

    private final Object target;

    public ProxyLzy(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method" + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method" + method.getName());
        return result;
    }
}

class ProxyFactory {
    public static Object getFactory(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ProxyLzy(target));
    }
}

package schema.proxy;

import org.junit.Test;

/**
 * @author linzy
 * @create 2021-02-27 12:12:16
 */
public class TestProxy {

    @Test
    public void testStaticProxy(){
        // 目标对象
        IUserDao target = new UserDao();
        // 代理
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();
    }

    @Test
    public void testDynamicProxy(){
        IUserDao target = new UserDao();
        System.out.println(target.getClass());
        IUserDao proxy = ((IUserDao) new UserProxyFactory(target).getProxyInstance());
        System.out.println(proxy.getClass());
        proxy.save();
    }
}

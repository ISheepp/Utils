package lxf.reflect;

import entity.Book;
import entity.Student;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author linzy
 * @create 2021-01-18 15:29:08
 */
public class MyReflectTest {

    @Test
    public void testGetClassInfo() throws ClassNotFoundException {
        // 四种方式
        Class<String> cls = String.class;
        String s = "123";
        Class cls1 = s.getClass();
        // 写出完整的类名
        Class<?> cls2 = Class.forName("java.lang.String");
    }

    @Test
    public void testPrintClassInfo(){
        printInfo("".getClass());
        System.out.println("======================================");
        printInfo(Runnable.class);
        System.out.println("======================================");
        printInfo(java.time.Month.class);
        System.out.println("======================================");
        printInfo(String[].class);
        System.out.println("======================================");
        printInfo(int.class);
    }

    @Test
    public void test1(){
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good Morning " + args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                handler);
        hello.morning("Bob");
    }

    @Test
    public void testObj() throws NoSuchFieldException {
        Class cls = Student.class;
        System.out.println("cls.getField() = " + cls.getField("price"));
        System.out.println("cls.getDeclaredFields() = " + cls.getDeclaredField("name"));
    }

    interface Hello {
        void morning(String name);
    }

    static void printInfo(Class cls) {
        System.out.println("cls.getName() = " + cls.getName());
        System.out.println("cls.getSimpleName() = " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("cls.getPackage().getName() = " + cls.getPackage().getName());
        }
        System.out.println("cls.isInterface() = " + cls.isInterface());
        System.out.println("cls.isArray() = " + cls.isArray());
        System.out.println("cls.isPrimitive() = " + cls.isPrimitive());
    }

}

package annotation;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author linzy
 * @create 2021-01-20 11:51:52
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        ArrayList<String> strings = new ArrayList<>();
        strings.trimToSize();

        boolean b = Person.class.isAnnotationPresent(Report.class);
        System.out.println(b);
        // 获取注解
        Report report = Person.class.getAnnotation(Report.class);
        int type = report.type();
        System.out.println(type);

        // 通过反射获取
        Class<Person> cls = Person.class;
        // 判断是否有@Report这个注解
        if (cls.isAnnotationPresent(Report.class)) {

        }

    }
    @Test
    public void test(){
        WorkImpl workImpl = new WorkImpl();

        Work work = new WorkImpl();
        // 只有接口的方法
        work.play();
        work.stay();

        workImpl.implMethod();
        workImpl.stay();
        workImpl.play();
    }

    @Test
    public void test2(){
        Person[] ps = new Person[]{
                new Person("lizy", 99),
                new Person("izy1", 999),
                new Person("lzy2", 9999),
        };
        Arrays.sort(ps);
        System.out.println("ps = " + Arrays.toString(ps));
    }
}

import annotation.MyTest;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author ISheep
 * @create 2020/10/29 21:24
 */


public class TestAnnotation {

    @MyTest(description = "用户名", length = 12)
    private String username;

    @Test
    public void test(){
        // 获取类模板
        Class c = TestAnnotation.class;

        // 获取所有字段
        for (Field f : c.getDeclaredFields()) {
            if (f.isAnnotationPresent(MyTest.class)) {
                MyTest annotation = f.getAnnotation(MyTest.class);
                System.out.println("字段：[" + f.getName() + "]，描述:[" + annotation.description() + annotation.length());
            }
        }
    }

}

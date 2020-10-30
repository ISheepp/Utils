package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ISheep
 * @create 2020/10/29 20:26
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME) // 只有这个状态可以使用反射获取到注解
public @interface MyTest {

    String description();

    int length();

}

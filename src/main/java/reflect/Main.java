package reflect;

import java.util.Arrays;

/**
 * @author 林子洋
 * @create 2021-09-01 11:04:17
 */
public class Main {

    public static void main(String[] args) {
        JvmImpl jvm = new JvmImpl();
        Class<?>[] interfaces = jvm.getClass().getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println(interfaces[i].getCanonicalName());
        }
        System.out.println(Arrays.toString(interfaces));
    }

}

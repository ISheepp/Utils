package schema;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author linzy
 * @create 2021-03-06 11:16:46
 */
public enum EnumSingle {

    INSTANCE;

    public EnumSingle getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingle instance = EnumSingle.INSTANCE;
        EnumSingle instance1 = EnumSingle.INSTANCE;
        System.out.println(instance);
        System.out.println(instance1);
        Constructor<EnumSingle> constructor = EnumSingle.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        EnumSingle single = constructor.newInstance();
        System.out.println(single);
    }

}

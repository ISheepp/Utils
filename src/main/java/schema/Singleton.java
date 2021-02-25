package schema;

/**
 * @author linzy
 * @create 2021-02-25 21:59:16
 */
public class Singleton {

    private Singleton() {}

    public static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}

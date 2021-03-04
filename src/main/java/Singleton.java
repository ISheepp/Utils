/**
 * @author linzy
 * @create 2021-03-04 11:40:06
 */
public class Singleton {
    private Singleton(){}

    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return INSTANCE;
    }


    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
    }
}

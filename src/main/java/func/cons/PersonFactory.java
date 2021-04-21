package func.cons;

/**
 * Person工厂
 * @author linzy
 * @create 2021-04-21 10:18:11
 */
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}

package func;

import func.cons.Person;
import org.junit.Test;

import java.util.Optional;

/**
 * @author linzy
 * @create 2021-04-21 11:25:02
 */
public class OptionalTest {

    @Test
    public void test1(){
        System.out.println(test());

    }

    public String test() {
        Person person = new Person();
        person.setLastName("2123");
        person.setFirstName("111");
        return Optional.ofNullable(person)
                .map(Person::getFirstName)
                .orElse("unKnow");

    }

}

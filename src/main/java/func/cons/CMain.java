package func.cons;

import org.junit.Test;

/**
 * @author linzy
 * @create 2021-04-21 10:17:51
 */
public class CMain {

    @Test
    public void test(){
        /*PersonFactory<Person> personFactory = new PersonFactory<Person>() {
            @Override
            public Person create(String firstName, String lastName) {
                return new Person(firstName, lastName);
            }
        };*/
        PersonFactory<Person> personFactory = Person::new;
        personFactory.create("lzy", "asd");
    }

}

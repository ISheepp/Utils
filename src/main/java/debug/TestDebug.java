package debug;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

/**
 * @author lin
 * @create 2021-05-18 20:25:41
 */
public class TestDebug {

    @Test
    public void test(){
        Object[] res = Stream.of(1, 2, 3, 4, 5, 6, 7, 8).filter(i -> i % 2 == 0).filter(integer -> integer > 3).toArray();
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void test1(){
        List<Optional<Customer>> customers = Arrays.asList(
                Optional.of(new Customer("日拱一兵", 18)),
                Optional.of(new Customer("卑微的小开发", 22)),
                Optional.empty(),
                Optional.of(new Customer("OOT", 21)),
                Optional.empty(),
                Optional.of(new Customer("温柔一刀", 23)),
                Optional.empty()
        );

        long numberOf65PlusCustomers = customers
                .stream()
                .flatMap(c -> c
                        .map(Stream::of)
                        .orElseGet(Stream::empty))
                .filter(c -> c.getAge() > 18)
                .count();

        System.out.println(numberOf65PlusCustomers);

    }

    @Test
    public void testCollection(){
        Collection<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.removeIf(i -> list.remove(3));
        System.out.println("list = " + list);

    }

}

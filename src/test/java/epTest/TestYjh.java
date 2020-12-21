package epTest;

import org.junit.Test;
import resume.Person;

import java.time.DayOfWeek;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author linzy
 * @create 2020-12-16 10:42:38
 */

public class TestYjh {

    @Test
    public void testForListModCount(){

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if ("5".equals(s)) {
                list.remove(s);
            } else {
                System.out.println(s);
            }
        }
        System.out.println(list);
    }

    @Test
    public void test(){
        Random random = new Random(1);
        int i = random.nextInt(200);
        int j = random.nextInt(200);

    }

    // 测试在集合中寻找最大的东西😊
    @Test
    public void testMax(){
        // List<String> list = new ArrayList<>();
        // list.add("1");
        // list.add("3");
        // list.add("2");
        // list.add("4");
        // list.add("5");
        // Collections.sort(list);
        // String max = Collections.max(list);
        // System.out.println(max);
        // list.forEach(System.out::println);

        List<Person> list2 = new ArrayList<>();
        list2.add(new Person("lzy0", "22"));
        list2.add(new Person("lzy1", "21"));
        list2.add(new Person("lzy2", "23"));
        list2.add(new Person("lzy3", "26"));
        Optional<Person> max1 = list2.stream().max(Comparator.comparing(Person::getAge));
        System.out.println(max1.get().getName());
    }

    @Test
    public void testForSteam(){
        List<String> list = new ArrayList<>();
        list.add("3");
        list.add("1");
        list.add("2");
        list.add("4");
        list.add("5");
        List<Integer> asList = Arrays.asList(1, 3, 4, 2, 5, 6, 7, 8);
        // System.out.println(asList.stream().reduce(Integer::sum).get());
        //所有数乘积的两倍
        // System.out.println(asList.stream().reduce(2, (a, b) -> (a * b)));
        List<Integer> collect = list.stream().map((Integer::parseInt)).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }

}

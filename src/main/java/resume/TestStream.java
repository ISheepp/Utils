package resume;

import entity.Person;
import org.junit.Test;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 尝试函数式编程
 * @author linzy
 * @create 2020-12-05 16:12:33
 */
public class TestStream {

    @Test
    public void test(){
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        Arrays.sort(array, String::compareTo);
        System.out.println(String.join(", ", array));
    }

    @Test
    public void test1(){
        System.out.println("qwe".compareTo("asd"));  //q是113   a是97   。113-97=16
        System.out.println("201801".compareTo("201802"));//前五位相同 ， 1是49,2是50,49-50=-1

    }

    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("1");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        System.out.println(list.stream().count());
        System.out.println(list.stream().filter(s -> s.equals("1")).count());
    }

    /**
     * 打印前100个自然数的平方
     */
    @Test
    public void test3(){
        List<String> list = new ArrayList<>();
        list.add("  Apple ");
        list.add(" pear ");
        list.add(" ORANGE");
        list.add(" BaNaNa ");
        list.stream()
            .map(String::trim) // 去空格
            .map(String::toLowerCase) // 变小写
            .forEach(System.out::println); // 打印
        // 使用map()把一组String转换为LocalDate并打印。
        Stream<String> stringStream = Arrays.stream(new String[]{"2020-04-01","2020-04-02","2020-04-03","2020-04-04"});
        stringStream.map(LocalDate::parse).forEach(System.out::println);
    }

    /**
     * 测试foreach
     */
    @Test
    public void testForEach(){
        List<Person> list = new ArrayList<>();
        Person one = new Person("lzy", "12");
        Person two = new Person("qwe", "13");
        Person three = new Person("asd", "14");
        Person four = new Person("zxc", "15");
        Person five = new Person("bnm", "16");
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        // list.forEach(System.out::println);
        list.forEach((s)->{
            if (s.getName().equals("lzy")) {
                s.setAge("123");
            }
        });
        list.forEach(System.out::println);
    }

}

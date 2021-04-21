package func.lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author linzy
 * @create 2021-04-21 9:56:44
 */
public class Fmain {

    @Test
    public void test1(){
        Converter<String, Integer> converter = Integer::valueOf;
        System.out.println(converter.convert("123"));
    }

    @Test
    public void test2(){
        Converter<String, String> converter = Something::startWith;
        System.out.println(converter.convert("123"));
    }

    @Test
    public void test3(){
        Function<String, Integer> function = Integer::valueOf;
        Integer apply = function.apply("123");
        System.out.println(apply);
    }

    @Test
    public void test4(){
        List<String> list = Arrays.asList("123", "22", "222");
        list.stream().map(s -> {
            if (s.equals("123")) {
                return "hahaha" ;
            } else {
                return "a" ;
            }
        }).forEach(System.out::println);
        System.out.println("==================");
        list.forEach(System.out::println);

    }

    @Test
    public void testMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.entrySet().forEach(System.out::println);
        String s = "222" ;
        System.out.println(s.concat("22222"));
        System.out.println(s);
    }

}

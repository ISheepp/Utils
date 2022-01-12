package zkTest.util;

import com.google.common.collect.Lists;
import entity.Person;
import entity.Student;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author 林子洋
 * @create 2021-11-02 19:57:45
 */
public class StreamUtils {

    /**
     * 对象中的某个字段去重
     *
     * @param keyExtractor Function
     * @return Predicate
     */
    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        System.out.println("2222");
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static void main(String[] args) {
        List<Student> list = Lists.newArrayList(
                new Student("1", "11"),
                new Student("2", "1111111"),
                new Student("3", "11")
        );

        list.stream()
                .filter(distinctByKey(Student::getPrice))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

}

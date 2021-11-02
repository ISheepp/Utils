package zkTest.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

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
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}

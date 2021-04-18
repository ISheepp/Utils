package juc.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author linzy
 * @create 2021-03-02 20:56:43
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        list.forEach(System.out::println);

        List<String> list1 = Collections.synchronizedList(new ArrayList<>());

        // 线程安全，(写入时复制)
        List<String> list2 = new CopyOnWriteArrayList<>();
        list2.add(1, "2");

        // 线程安全的set
        Set<String> set = new CopyOnWriteArraySet<>();
    }
}

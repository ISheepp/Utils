package entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author linzy
 * @create 2021-01-14 14:42:18
 */
public class Book {

    private String name;

    private static Double price;

    void testFoo() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("sss");
                Map<String,Object> map = new ConcurrentHashMap<>();
            }
        };
    }

    public static void main(String[] args) {
        Book.price = 88d;
    }

}

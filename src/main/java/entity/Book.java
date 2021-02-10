package entity;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author linzy
 * @create 2021-01-14 14:42:18
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 4466525875136663702L;
    private String name;

    @SuppressWarnings("sss")
    private static Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Double getPrice() {
        return price;
    }

    public static void setPrice(Double price) {
        Book.price = price;
    }

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

package nullDeal;

import org.joda.time.DateTime;

import java.util.stream.Stream;

/**
 * @author linzy
 * @create 2021-04-20 14:52:28
 */
public class MyMain {

    public static void main(String[] args) {
        // Stream.generate(()-> "hhh").limit(20).forEach(System.out::println);
        DateTime dateTime = new DateTime().withTime(15, 0, 0, 0);
        System.out.println(dateTime);
    }
}

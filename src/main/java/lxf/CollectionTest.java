package lxf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ISheep
 * @create 2020/10/12 20:54
 */
public class CollectionTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator = list.iterator();
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("====================");
        //
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }

        boolean contains = list.contains("2");
        System.out.println(contains);

    }

}

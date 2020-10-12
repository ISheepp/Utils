package lxf;

import java.util.ArrayList;
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
        list.remove("3");
        for (String s : list) {
            System.out.println(s);
        }
    }

}

package lxf;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ISheep
 * @create 2020/10/13 19:44
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(16);
        map.put(1, "lzy");
        map.put(3, "lzy3");
        map.put(2, "lzy2");


        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }

        System.out.println("============================");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }

}

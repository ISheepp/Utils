import java.util.ArrayList;
import java.util.List;

/**
 * @author 林子洋靓
 * @create 2021-05-21 15:30:33
 */
public class NumberTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        if (list == null) {
            System.out.println("222");
        }
        System.out.println(list);
        System.out.println(list.size());
    }

}

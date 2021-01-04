import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author lin
 * @create 2020-10-05 14:47
 */
public class TestEnum {

    // @Test
    // public void testEnum() {
    //     //language=JSON
    //     String json = "{\n" +
    //             "  " +
    //             "\"name\": \"林子洋\",\n" +
    //             "  \"age\": 22\n" +
    //             "}";
    //     System.out.println(json);
    // }
    //
    // @Test
    // public void test(){
    //     int a = 72;
    //     Character b = '\u0000';
    //     char q = b;
    //     System.out.println(b);
    //     System.out.println(q);
    // }

    public static void main(String[] args) {
        System.out.println("Please input: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(Arrays.toString(args));
        System.out.println(s);
    }

}

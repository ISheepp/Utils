import juc.function.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linzy
 * @create 2021-04-28 16:16:45
 */
public class MapTest {

    @Test
    public void test(){
        User user = new User(12, "lzy", 22);
        Map<String, Object> map = new HashMap<>();
        map.put("1", user);
        System.out.println(map + "123");
        user.setName("123");
        System.out.println(user);
        System.err.println(map);
    }

    @Test
    public void test1(){
        String s = "18 00 00 00 3c 00 48 00 65 00 61 00 72 00 74 00 42 00 65 00 61 00 74 00 2f 00 3e 00";
        String x = "e6 01 00 00 3c 00 3f 00 78 00 6d 00 6c 00 20 00 76 00 65 00 72 00 73 00 69 00 6f 00 6e 00 3d 00 " +
                "22 00 31 00 2e 00 30 00 22 00 20 00 65 00 6e 00 63 00 6f 00 64 00 69 00 6e 00 67 00 3d 00 22 00 75 " +
                "00 74 00 66 00 2d 00 31 00 36 00 22 00 3f 00 3e 00 0a 00 3c 00 43 00 6f 00 6d 00 70 00 61 00 6e 00 " +
                "79 00 49 00 64 00 65 00 6e 00 74 00 69 00 74 00 79 00 20 00 78 00 6d 00 6c 00 6e 00 73 00 3a 00 78 " +
                "00 73 00 69 00 3d 00 22 00 68 00 74 00 74 00 70 00 3a 00 2f 00 2f 00 77 00 77 00 77 00 2e 00 77 00 " +
                "33 00 2e 00 6f 00 72 00 67 00 2f 00 32 00 30 00 30 00 31 00 2f 00 58 00 4d 00 4c 00 53 00 63 00 68 " +
                "00 65 00 6d 00 61 00 2d 00 69 00 6e 00 73 00 74 00 61 00 6e 00 63 00 65 00 22 00 20 00 78 00 6d 00 " +
                "6c 00 6e 00 73 00 3a 00 78 00 73 00 64 00 3d 00 22 00 68 00 74 00 74 00 70 00 3a 00 2f 00 2f 00 77 " +
                "00 77 00 77 00 2e 00 77 00 33 00 2e 00 6f 00 72 00 67 00 2f 00 32 00 30 00 30 00 31 00 2f 00 58 00 " +
                "4d 00 4c 00 53 00 63 00 68 00 65 00 6d 00 61 00 22 00 3e 00 0a 00 3c 00 43 00 6f 00 6d 00 70 00 61 " +
                "00 6e 00 79 00 43 00 6f 00 64 00 65 00 3e 00 58 00 4d 00 4a 00 44 00 54 00 54 00 65 00 73 00 74 00 " +
                "3c 00 2f 00 43 00 6f 00 6d 00 70 00 61 00 6e 00 79 00 43 00 6f 00 64 00 65 00 3e 00 0a 00 3c 00 50 " +
                "00 61 00 73 00 73 00 57 00 6f 00 72 00 64 00 3e 00 58 00 4d 00 4a 00 44 00 54 00 54 00 65 00 73 00 " +
                "74 00 3c 00 2f 00 50 00 61 00 73 00 73 00 57 00 6f 00 72 00 64 00 3e 00 0a 00 3c 00 2f 00 43 00 6f " +
                "00 6d 00 70 00 61 00 6e 00 79 00 49 00 64 00 65 00 6e 00 74 00 69 00 74 00 79 00 3e 00";
        // 中文
        String a = "f5 01 00 00 3c 00 3f 00 78 00 6d 00 6c 00 20 00 76 00 65 00 72 00 73 00 69 00 6f 00 6e 00 3d 00 " +
                "22 00 31 00 2e 00 30 00 22 00 20 00 65 00 6e 00 63 00 6f 00 64 00 69 00 6e 00 67 00 3d 00 22 00 75 " +
                "00 74 00 66 00 2d 00 31 00 36 00 22 00 3f 00 3e 00 0a 00 3c 00 43 00 6f 00 6d 00 70 00 61 00 6e 00 " +
                "79 00 49 00 64 00 65 00 6e 00 74 00 69 00 74 00 79 00 20 00 78 00 6d 00 6c 00 6e 00 73 00 3a 00 78 " +
                "00 73 00 69 00 3d 00 22 00 68 00 74 00 74 00 70 00 3a 00 2f 00 2f 00 77 00 77 00 77 00 2e 00 77 00 " +
                "33 00 2e 00 6f 00 72 00 67 00 2f 00 32 00 30 00 30 00 31 00 2f 00 58 00 4d 00 4c 00 53 00 63 00 68 " +
                "00 65 00 6d 00 61 00 2d 00 69 00 6e 00 73 00 74 00 61 00 6e 00 63 00 65 00 22 00 20 00 78 00 6d 00 " +
                "6c 00 6e 00 73 00 3a 00 78 00 73 00 64 00 3d 00 22 00 68 00 74 00 74 00 70 00 3a 00 2f 00 2f 00 77 " +
                "00 77 00 77 00 2e 00 77 00 33 00 2e 00 6f 00 72 00 67 00 2f 00 32 00 30 00 30 00 31 00 2f 00 58 00 " +
                "4d 00 4c 00 53 00 63 00 68 00 65 00 6d 00 61 00 22 00 3e 00 0a 00 3c 00 43 00 6f 00 6d 00 70 00 61 " +
                "00 6e 00 79 00 43 00 6f 00 64 00 65 00 3e 00 36 66 33 33 00 35 64 64 65 00 34 65 61 34 00 39 30 31 " +
                "61 00 35 63 34 30 00 3c 00 2f 00 43 00 6f 00 6d 00 70 00 61 00 6e 00 79 00 43 00 6f 00 64 00 65 00 " +
                "3e 00 0a 00 3c 00 50 00 61 00 73 00 73 00 57 00 6f 00 72 00 64 00 3e 00 7a 00 7a 00 6a 00 74 00 6a " +
                "00 32 00 30 00 32 00 31 00 30 00 34 00 30 00 39 00 3c 00 2f 00 50 00 61 00 73 00 73 00 57 00 6f 00 " +
                "72 00 64 00 3e 00 0a 00 3c 00 2f 00 43 00 6f 00 6d 00 70 00 61 00 6e 00 79 00 49 00 64 00 65 00 6e " +
                "00 74 00 69 00 74 00 79 00 3e 00 ";
        // 英文
        String b = "e8 01 00 00 3c 00 3f 00 78 00 6d 00 6c 00 20 00 76 00 65 00 72 00 73 00 69 00 6f 00 6e 00 3d 00 " +
                "22 00 31 00 2e 00 30 00 22 00 20 00 65 00 6e 00 63 00 6f 00 64 00 69 00 6e 00 67 00 3d 00 22 00 75 " +
                "00 74 00 66 00 2d 00 31 00 36 00 22 00 3f 00 3e 00 0a 00 3c 00 43 00 6f 00 6d 00 70 00 61 00 6e 00 " +
                "79 00 49 00 64 00 65 00 6e 00 74 00 69 00 74 00 79 00 20 00 78 00 6d 00 6c 00 6e 00 73 00 3a 00 78 " +
                "00 73 00 69 00 3d 00 22 00 68 00 74 00 74 00 70 00 3a 00 2f 00 2f 00 77 00 77 00 77 00 2e 00 77 00 " +
                "33 00 2e 00 6f 00 72 00 67 00 2f 00 32 00 30 00 30 00 31 00 2f 00 58 00 4d 00 4c 00 53 00 63 00 68 " +
                "00 65 00 6d 00 61 00 2d 00 69 00 6e 00 73 00 74 00 61 00 6e 00 63 00 65 00 22 00 20 00 78 00 6d 00 " +
                "6c 00 6e 00 73 00 3a 00 78 00 73 00 64 00 3d 00 22 00 68 00 74 00 74 00 70 00 3a 00 2f 00 2f 00 77 " +
                "00 77 00 77 00 2e 00 77 00 33 00 2e 00 6f 00 72 00 67 00 2f 00 32 00 30 00 30 00 31 00 2f 00 58 00 " +
                "4d 00 4c 00 53 00 63 00 68 00 65 00 6d 00 61 00 22 00 3e 00 0a 00 3c 00 43 00 6f 00 6d 00 70 00 61 " +
                "00 6e 00 79 00 43 00 6f 00 64 00 65 00 3e 00 58 00 4d 00 4a 00 44 00 54 00 54 00 65 00 73 00 74 00 " +
                "3c 00 2f 00 43 00 6f 00 6d 00 70 00 61 00 6e 00 79 00 43 00 6f 00 64 00 65 00 3e 00 0a 00 3c 00 50 " +
                "00 61 00 73 00 73 00 57 00 6f 00 72 00 64 00 3e 00 58 00 4d 00 4a 00 44 00 54 00 54 00 65 00 73 00 " +
                "74 00 73 00 3c 00 2f 00 50 00 61 00 73 00 73 00 57 00 6f 00 72 00 64 00 3e 00 0a 00 3c 00 2f 00 43 " +
                "00 6f 00 6d 00 70 00 61 00 6e 00 79 00 49 00 64 00 65 00 6e 00 74 00 69 00 74 00 79 00 3e 00 ";
        String lzy = "e1 01 00 00 3c 00 3f 00 78 00 6d 00 6c 00 20 00 76 00 65 00 72 00 73 00 69 00 6f 00 6e 00 3d 00" +
                " 22 00 31 00 2e 00 30 00 22 00 20 00 65 00 6e 00 63 00 6f 00 64 00 69 00 6e 00 67 00 3d 00 22 00 75 " +
                "00 74 00 66 00 2d 00 31 00 36 00 22 00 3f 00 3e 00 0a 00 3c 00 43 00 6f 00 6d 00 70 00 61 00 6e 00 " +
                "79 00 49 00 64 00 65 00 6e 00 74 00 69 00 74 00 79 00 20 00 78 00 6d 00 6c 00 6e 00 73 00 3a 00 78 " +
                "00 73 00 69 00 3d 00 22 00 68 00 74 00 74 00 70 00 3a 00 2f 00 2f 00 77 00 77 00 77 00 2e 00 77 00 " +
                "33 00 2e 00 6f 00 72 00 67 00 2f 00 32 00 30 00 30 00 31 00 2f 00 58 00 4d 00 4c 00 53 00 63 00 68 " +
                "00 65 00 6d 00 61 00 2d 00 69 00 6e 00 73 00 74 00 61 00 6e 00 63 00 65 00 22 00 20 00 78 00 6d 00 " +
                "6c 00 6e 00 73 00 3a 00 78 00 73 00 64 00 3d 00 22 00 68 00 74 00 74 00 70 00 3a 00 2f 00 2f 00 77 " +
                "00 77 00 77 00 2e 00 77 00 33 00 2e 00 6f 00 72 00 67 00 2f 00 32 00 30 00 30 00 31 00 2f 00 58 00 " +
                "4d 00 4c 00 53 00 63 00 68 00 65 00 6d 00 61 00 22 00 3e 00 0a 00 3c 00 43 00 6f 00 6d 00 70 00 61 " +
                "00 6e 00 79 00 43 00 6f 00 64 00 65 00 3e 00 36 66 33 33 00 3c 00 2f 00 43 00 6f 00 6d 00 70 00 61 " +
                "00 6e 00 79 00 43 00 6f 00 64 00 65 00 3e 00 0a 00 3c 00 50 00 61 00 73 00 73 00 57 00 6f 00 72 00 " +
                "64 00 3e 00 7a 00 7a 00 6a 00 74 00 6a 00 32 00 30 00 32 00 31 00 30 00 34 00 30 00 39 00 3c 00 2f " +
                "00 50 00 61 00 73 00 73 00 57 00 6f 00 72 00 64 00 3e 00 0a 00 3c 00 2f 00 43 00 6f 00 6d 00 70 00 " +
                "61 00 6e 00 79 00 49 00 64 00 65 00 6e 00 74 00 69 00 74 00 79 00 3e 00";


        String newMSg = "f0 01 00 00 3c 00 3f 00 78 00 6d 00 6c 00 20 00 76 00 65 00 72 00 73 00 69 00 6f 00 6e 00 3d" +
                " 00 22 00 31 00 2e 00 30 00 22 00 20 00 65 00 6e 00 63 00 6f 00 64 00 69 00 6e 00 67 00 3d 00 22 00 " +
                "75 00 74 00 66 00 2d 00 31 00 36 00 22 00 3f 00 3e 00 0a 00 3c 00 43 00 6f 00 6d 00 70 00 61 00 6e " +
                "00 79 00 49 00 64 00 65 00 6e 00 74 00 69 00 74 00 79 00 20 00 78 00 6d 00 6c 00 6e 00 73 00 3a 00 " +
                "78 00 73 00 69 00 3d 00 22 00 68 00 74 00 74 00 70 00 3a 00 2f 00 2f 00 77 00 77 00 77 00 2e 00 77 " +
                "00 33 00 2e 00 6f 00 72 00 67 00 2f 00 32 00 30 00 30 00 31 00 2f 00 58 00 4d 00 4c 00 53 00 63 00 " +
                "68 00 65 00 6d 00 61 00 2d 00 69 00 6e 00 73 00 74 00 61 00 6e 00 63 00 65 00 22 00 20 00 78 00 6d " +
                "00 6c 00 6e 00 73 00 3a 00 78 00 73 00 64 00 3d 00 22 00 68 00 74 00 74 00 70 00 3a 00 2f 00 2f 00 " +
                "77 00 77 00 77 00 2e 00 77 00 33 00 2e 00 6f 00 72 00 67 00 2f 00 32 00 30 00 30 00 31 00 2f 00 58 " +
                "00 4d 00 4c 00 53 00 63 00 68 00 65 00 6d 00 61 00 22 00 3e 00 0a 00 3c 00 43 00 6f 00 6d 00 70 00 " +
                "61 00 6e 00 79 00 43 00 6f 00 64 00 65 00 3e 00 e6 bc b3 00 e5 b7 9e 00 e4 ba a4 00 e9 80 9a 00 e5 " +
                "b1 80 00 3c 00 2f 00 43 00 6f 00 6d 00 70 00 61 00 6e 00 79 00 43 00 6f 00 64 00 65 00 3e 00 0a 00 " +
                "3c 00 50 00 61 00 73 00 73 00 57 00 6f 00 72 00 64 00 3e 00 7a 00 7a 00 6a 00 74 00 6a 00 32 00 30 " +
                "00 32 00 31 00 30 00 34 00 30 00 39 00 3c 00 2f 00 50 00 61 00 73 00 73 00 57 00 6f 00 72 00 64 00 " +
                "3e 00 0a 00 3c 00 2f 00 43 00 6f 00 6d 00 70 00 61 00 6e 00 79 00 49 00 64 00 65 00 6e 00 74 00 69 " +
                "00 74 00 79 00 3e 00 ";
        System.out.println(newMSg.replace(" ", ""));
    }

    @Test
    public void test2(){
        String s = "6f33";
        String s1 = s.substring(0,2);
        String s2 = s.substring(2);
        System.out.println(s1);

        byte[] a = new byte[4];

        System.out.println(changeBytes(a));
    }

    @Test
    public void testLzy(){
        String s = "lzy";

        s.charAt(1);
    }

    public static byte[] changeBytes(byte[] a) {
        byte[] b = new byte[a.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[b.length - i - 1];
        }
        return b;
    }


}

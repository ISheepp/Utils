package http;


import java.util.Arrays;

/**
 * @author 林子洋靓
 * @create 2021-05-14 10:37:08
 * 编写一个简易的http服务器
 * 1.
 */
public class Server {

    public static void main(String[] args) {
        int i, j = 0;
        byte[] bytes = new byte[]{1, 2, 3, 5, 3, -2, -4, -6, -1, -9, 2, 4, 2, -1, -2, -3, 3, 4, 6};
        byte[] newByte = new byte[1024];
        for (i = 0; i < bytes.length; i++) {
            if (bytes[i] < 0) {
                // 英文
                byte[] a1 = Arrays.copyOfRange(bytes, j, i);
                j = i;
                // ArrayUtil.addAll(newByte, a1);
                System.arraycopy(a1, 0, newByte, 0, a1.length);
                System.err.println(Arrays.toString(a1));
                for (int k = i; k < bytes.length; k++) {
                    if (bytes[k] > 0) {
                        // 中文
                        byte[] a2 = Arrays.copyOfRange(bytes, j, k);
                        System.arraycopy(a2, 0, newByte, 0, a2.length);
                        System.out.println(Arrays.toString(a2));
                        // ArrayUtil.addAll(newByte, a2);
                        j = k;
                        i = k;
                        break;
                    }
                }
            } else if (i == bytes.length - 1) {
                // 最后一段英文
                byte[] last = Arrays.copyOfRange(bytes, j, i + 1);
                System.err.println(Arrays.toString(last));
                // ArrayUtil.addAll(newByte, last);
            }
        }
        System.out.println("----------------------");
        System.out.println(Arrays.toString(newByte));
    }

}

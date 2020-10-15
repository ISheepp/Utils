package lxf.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ISheep
 * @create 2020/10/15 10:02
 */
public class demo2Input {
    public static void main(String[] args) throws IOException {
        InputStream input = new FileInputStream("README.md");
        for (;;) {
            int n = input.read(); // 反复调用read()方法，直到返回-1
            if (n == -1) {
                break;
            }
            System.out.println(n); // 打印byte的值
        }
        input.close(); // 关闭流
    }
}

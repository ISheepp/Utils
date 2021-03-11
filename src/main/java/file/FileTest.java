package file;

import java.io.*;

/**
 * @author linzy
 * @create 2021-03-09 17:45:03
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\project\\github\\Utils\\src\\main\\java\\file\\Readme.txt");
        InputStream in = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(in);
        for (;;){
            int n = input.read();
            if (n == -1) {
                break;
            }
            System.out.println(n);
        }
    }

}

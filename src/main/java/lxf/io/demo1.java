package lxf.io;

import java.io.File;
import java.io.IOException;

/**
 * @author ISheep
 * @create 2020/10/14 21:28
 */
public class demo1 {

    public static void main(String[] args) throws IOException {
        File f = new File("F:\\io\\test.txt");
        System.out.println(f);
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
        System.out.println();
    }

}

package lxf.io;

import java.io.File;
import java.io.IOException;

/**
 * @author ISheep
 * @create 2020/10/15 9:50
 */
public class Create {

    public static void main(String[] args) throws IOException {
        File file = new File("src/file.txt");
        if (file.createNewFile()) {
            System.out.println("文件创建成功");
            if (file.delete()) {
                System.out.println("文件删除");
            }
        }
    }
}

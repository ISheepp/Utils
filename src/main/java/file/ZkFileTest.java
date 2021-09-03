package file;

import java.io.File;

/**
 * @author 林子洋
 * @create 2021-09-02 17:53:14
 */
public class ZkFileTest {

    public static void main(String[] args) {
        File file = new File("D:\\backup\\arith\\test\\upload\\business-template-1.0.0-ark-biz-20210902143206.jar");
        System.out.println(file.toURI());
        System.out.println(file.delete());
    }

}

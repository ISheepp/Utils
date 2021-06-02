package zkTest;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author 林子洋靓
 * @create 2021-06-02 9:38:11
 */
public class ZkTest {

    @Test
    public void test(){
        Random random = new Random(11);
        Random random1 = new Random(11);
        System.out.println(random.nextInt());
        System.out.println(random1.nextInt());
    }

    @Test
    public void testZuanShi(){
        Sheep<String> sheep = new Sheep<>();
        String s = sheep.getLzyTest("s");
        System.out.println(s);
    }

    @Test
    public void test1(){
        String date = "2021/1/2";
        Date x = Convert.toDate(date);
        System.out.println(x);
    }

    @Test
    public void testFileUtil(){
        File[] files = FileUtil.ls("D:\\pai");
        List<File> fileList = Convert.toList(File.class, files);
        fileList.forEach(System.out::println);
    }

}

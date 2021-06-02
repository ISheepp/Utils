package zkTest;

import cn.hutool.core.convert.Convert;
import org.junit.Test;

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

}

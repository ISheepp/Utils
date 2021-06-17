package zkTest;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import static org.junit.Assert.*;

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

    @Test
    public void testInstant(){
        DecimalFormat df = new DecimalFormat("0.000");
        Double num = 0.000000000000002;
        double num1 = 2.000000000000002;

        String format = df.format(num1);
        BigDecimal bg = new BigDecimal(format);
        System.err.println(Double.valueOf(format));
        System.out.println(format);
        double x = bg.doubleValue();
        System.out.println(x);
    }

    @Test
    public void testCache() throws ExecutionException {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("csc","1");
        multimap.put("lwl","1");
        multimap.put("csc","1");
        multimap.put("lwl","one");
        System.out.println(multimap.get("csc"));
        System.out.println(multimap.get("lwl"));

    }

    @Test
    public void testENV(){


    }

}

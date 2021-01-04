import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import entity.Student;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 * @author ISheep
 * @create 2020/11/24 20:06
 */
public class IsheepTests {

    @Test
    public void test(){
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        System.out.println("i1=i2 " + (i1 == i2));
        System.out.println("i1=i2+i3 " + (i1 == i2 + i3));
        System.out.println("i1=i4 " + (i1 == i4));
        System.out.println("i4=i5 " + (i4 == i5));
        System.out.println("i4=i5+i6 " + (i4 == i5 + i6));
        System.out.println("40=i5+i6 " + (40 == i5 + i6));
    }

    @Test
    public void testYM(){
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        System.out.println(cal.get(Calendar.HOUR));

    }

    @Test
    public void testOverTime(){
        // getTime()获取的是ms，也就是说要加000才能是秒
        Date date = new Date(1607149574042L);
        Date date1 = new Date(1607149574322L);

        if (date1.getTime() - date.getTime() > 200) {
            System.out.println("sss");
        }
    }

    @Test
    public void testForArray(){
        Integer[] ns = {11, 2, 32, 44, 5, 8, 13};
        // 正序排序
        Arrays.sort(ns);
        System.out.println(Arrays.toString(ns));
        // 降序
        Arrays.sort(ns, Collections.reverseOrder());
        System.out.println(Arrays.toString(ns));

    }

    @Test
    public void testStu(){
        Student student = new Student();
        student.setName("yyy");
        System.out.println(JSON.toJSONString(student,
                SerializerFeature.PrettyFormat,
                SerializerFeature.UseSingleQuotes));
    }

    @Test
    public void testMethod(){
        String s = "  sadasd ";
        System.out.println(s.trim());
        System.out.println(s);
    }

}

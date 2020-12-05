import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
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

}

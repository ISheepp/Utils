import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.util.BeanUtil;
import entity.BeanBook;
import entity.BeanBook2;
import entity.Student;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import sun.security.util.AuthResources_it;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ISheep
 * @create 2020/11/24 20:06
 */
public class IsheepTests {

    @Test
    public void testTime(){
        System.err.println(LocalDateTime.now());
    }

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

    @Test
    public void testSplit(){
        String badstr = "exec | and |execute |insert |select |delete |update |count(|drop |master |truncate |"
                + "char |declare |sitename |net user |xp_cmdshell |like'|create |"
                + " table|from|grant | use |group_concat(|column_name |"
                + "information_schema.columns|table_schema |union |where |"
                + " or |like |(+)|--";// 过滤掉的sql关键字，可以手动添加
        String[] split = badstr.split("\\|");
        for (String s : split) {
            System.out.println(s);
        }
    }
    
    @Test
    public void testForExecutor(){

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(() -> System.out.println("test!!!"));
        }
        service.shutdown();
    }
    
    @Test
    public void testString(){
        String s = "test String methods";
        int i = s.indexOf("String");
        System.out.println(i);
    }
    
    @Test
    public void testBigDecimal(){
        BigDecimal bd = new BigDecimal("123.123");
        BigDecimal bd2 = new BigDecimal("23.123");
        BigDecimal[] bigDecimals = bd.divideAndRemainder(bd2);
        System.err.println(bigDecimals[0]);
        System.err.println(bigDecimals[1]);
    }

    @Test
    public void testRandom(){
        // 这是因为我们创建Random实例时，如果不给定种子，就使用系统当前时间戳作为种子，因此每次运行时，种子不同，得到的伪随机数序列就不同。
        Random random = new Random(12345);
        System.out.println(random.nextInt());
    }

    @Test
    public void testSecureRandom(){
        SecureRandom random = null;
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            random = new SecureRandom();
        }
        byte[] buffer = new byte[16];
        random.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));

    }

    @Test
    public void testList(){
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.indexOf("3"));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // 找出缺失的数字
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        // 如果没有该元素会返回-1
        for (int i = start; i <= end; i++) {
            if (list.indexOf(i) != -1)
                continue;
            else
                return i;

        }
        return 0;
    }

    @Test
    public void testMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("1", 2);
        map.put("2", 3);
        // 遍历map
        // 1.
        for (String s : map.keySet()) {
            System.out.println("key= " + s + " and value= " + map.get(s));
        }
        System.out.println("================================");
        // 2.
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            // K
            String key = entry.getKey();
            // V
            Object value = entry.getValue();
            System.out.println("K= " + key + " and V = " + value);
        }
        // 3. 性能不如entrySet
        map.forEach((key, value) -> System.out.println("K= " + key + " and V = " + value));

    }

    @Test
    public void testForBeanUtils(){
        BeanBook one = new BeanBook();
        BeanBook2 two = new BeanBook2();
        one.setName1("lzy").setDescription("description").setPrice(23.2);
        BeanUtils.copyProperties(one, two);

        System.err.println(one);
        System.err.println(two);
    }

    @Test
    public void testAssert(){
        List<String> list = new ArrayList<>();
        list.add("bsd");
        list.add("asd");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
        list.forEach(System.out::println);
    }

    @Test
    public void test111() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(new Date()));
        System.out.println(sdf.parse("2020-12-12"));
    }

    @Test
    public void testL(){
    }

}

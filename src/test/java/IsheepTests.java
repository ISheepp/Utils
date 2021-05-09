import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.LRUMap;
import entity.Apple;
import entity.BeanBook;
import entity.BeanBook2;
import entity.Person;
import entity.Student;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import sun.security.util.AuthResources_it;

import java.lang.reflect.*;
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
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ISheep
 * @create 2020/11/24 20:06
 */
public class IsheepTests {

    @Test
    public void testTime() {
        System.err.println(LocalDateTime.now());
    }

    @Test
    public void test() {
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
    public void testYM() {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        System.out.println(cal.get(Calendar.HOUR));

    }

    @Test
    public void testOverTime() {
        // getTime()获取的是ms，也就是说要加000才能是秒
        Date date = new Date(1607149574042L);
        Date date1 = new Date(1607149574322L);

        if (date1.getTime() - date.getTime() > 200) {
            System.out.println("sss");
        }
    }

    @Test
    public void testForArray() {
        Integer[] ns = {11, 2, 32, 44, 5, 8, 13};
        // 正序排序
        Arrays.sort(ns);
        System.out.println(Arrays.toString(ns));
        // 降序
        Arrays.sort(ns, Collections.reverseOrder());
        System.out.println(Arrays.toString(ns));

    }

    @Test
    public void testStu() {
        Student student = new Student();
        student.setName("yyy");
        System.out.println(JSON.toJSONString(student,
                SerializerFeature.PrettyFormat,
                SerializerFeature.UseSingleQuotes));
    }

    @Test
    public void testMethod() {
        String s = "  sadasd ";
        System.out.println(s.trim());
        System.out.println(s);
    }

    @Test
    public void testSplit() {
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
    public void testForExecutor() {

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(() -> System.out.println("test!!!"));
        }
        service.shutdown();
    }

    @Test
    public void testString() {
        String s = "test String methods";
        int i = s.indexOf("String");
        System.out.println(i);
    }

    @Test
    public void testBigDecimal() {
        BigDecimal bd = new BigDecimal("123.123");
        BigDecimal bd2 = new BigDecimal("23.123");
        BigDecimal[] bigDecimals = bd.divideAndRemainder(bd2);
        System.err.println(bigDecimals[0]);
        System.err.println(bigDecimals[1]);
    }

    @Test
    public void testRandom() {
        // 这是因为我们创建Random实例时，如果不给定种子，就使用系统当前时间戳作为种子，因此每次运行时，种子不同，得到的伪随机数序列就不同。
        Random random = new Random(12345);
        System.out.println(random.nextInt());
    }

    @Test
    public void testSecureRandom() {
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
    public void testList() {
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
    public void testMap() {
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
    public void testForBeanUtils() {
        BeanBook one = new BeanBook();
        BeanBook2 two = new BeanBook2();
        one.setName1("lzy").setDescription("description").setPrice(23.2);
        BeanUtils.copyProperties(one, two);

        System.err.println(one);
        System.err.println(two);
    }

    @Test
    public void testAssert() {
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
    public void testL() {
        Apple apple1 = new Apple(1, "苹果1", new BigDecimal("3.25"), 10);
        Apple apple12 = new Apple(1, "苹果2", new BigDecimal("1.35"), 20);
        Apple apple123 = new Apple(1, "苹果2", new BigDecimal("3.1235"), 220);
        Apple apple2 = new Apple(2, "香蕉", new BigDecimal("2.89"), 30);
        Apple apple3 = new Apple(3, "荔枝", new BigDecimal("9.99"), 40);

        List<Apple> list = new ArrayList<>();
        list.add(apple1);
        list.add(apple12);
        list.add(apple123);
        list.add(apple2);
        list.add(apple3);

        // 1、List以Id分组，Map<Integer, List<Apple>
        Map<Integer, List<Apple>> map = list.stream().collect(Collectors.groupingBy(Apple::getId));
        // System.err.println("map = " + map);

        // 2、List转Map
        Map<Integer, Apple> collect = list.stream().collect(Collectors.toMap(Apple::getId, a -> a, (k1, k2) -> k1));
        System.out.println("collect = " + collect);

    }

    @Test
    public void testSubList() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("12");
        list.add("123");
        list.add("1234");
        List<String> list1 = list.subList(0, 2);
        list.add("1111");
        list1.forEach(System.out::println);
    }

    @Test
    public void testDequeue() {
        String json = "{\n" +
                "    \"FUNTYPE\": [],\n" +
                "    \"NODETYPE\": [],\n" +
                "    \"ISLOG\": [],\n" +
                "    \"AAE100\": [],\n" +
                "    \"AUFLAG\": [],\n" +
                "    \"RBFLAG\": [],\n" +
                "    \"SLEVEL\": [],\n" +
                "    \"SYSTEM\": [],\n" +
                "    \"SYSTEM\": []\n" +
                "}";
        // System.out.println(json);

        JSONObject jsonObject = JSONObject.parseObject(json);
        Set<String> strings = jsonObject.keySet();
    }

    /**
     * 手机号脱敏
     */
    @Test
    public void testTM() {
        String phone = "508e6697b94f8ed4";
        System.out.println(desensitizedPhoneNumber(phone));
    }

    private static String desensitizedPhoneNumber(String secureKey) {
        if (!StringUtils.isEmpty(secureKey)) {
            secureKey = secureKey.replaceAll("(\\w{3})\\w*(\\w{4})", "$1*********$2");
        }
        return secureKey;
    }

    @Test
    public void testCompare() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.sort(Comparator.naturalOrder());
    }

    @Test
    public void testHashMap() {
        int[] array = new int[4];
        double[] array2 = new double[2];
        System.out.println(array2.getClass());
        System.out.println(array.getClass());
    }

    @Test
    public void testStream() {
        Stream<String> stream = Stream.of("hello", "world", "helloworld");
        List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
    }

    @Test
    public void testNum() {
        // Integer[] nums = new Integer[]{3, 2, 4};
        // Integer sum = Stream.of(nums).reduce(1, (n1, n2) -> n1 * n2);
        // System.out.println(sum);

        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6};
        System.out.println(Stream.of(nums).filter(item -> item > 3)
                .peek(item -> System.out.print(item + 1))
                .peek(System.out::print)
                .reduce(0, Integer::sum));
    }

    @Test
    public void testX() {
        Integer x = 2;
        Integer integer = Integer.valueOf(2); // 装箱
        int y = x.intValue(); // 拆箱
        System.out.println(Objects.equals(null, "null"));
        BigDecimal bigDecimal = new BigDecimal("1.0");
    }

    @Test
    public void testlzy() {
        Integer[] myArray = {1, 2, 3};
        List<Integer> collect = Arrays.stream(myArray).collect(Collectors.toList());
        int[] array = {1, 2, 3};
        Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println(array.length);
        Collections.sort(collect, Integer::compareTo);
    }

    @Test
    public void test555() {
        Map<String, Object> map = new HashMap<>();
        map.put("1", null);
        map.put(null, 1235);
        map.put(null, 123656);
        map.forEach((k, v) -> System.out.println(k + "===" + v));
        int a = '2';
        System.out.println(a);
    }

    @Test
    public void testPl() {
        int[] array = {3, 5, 2, 4, 7};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    // int tem = array[j];
                    // array[j] = array[j + 1];
                    // array[j + 1] = tem;
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                    array[j + 1] = array[j + 1] + array[j];
                }
            }
        }
        System.out.println(Arrays.toString(array));
        int[] ints = Arrays.copyOf(array, 2);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test22() {
        int i = 2;

        switch (i) {
            case 1:
                i++;
            case 2:
                i++;
            case 3:
                i++;
            default:
                System.out.println("hhh");
            case 4:
                i++;
        }

        System.out.println(i);
    }

    /**
     * 跳出多重循环
     */
    @Test
    public void test1555() throws InterruptedException {
        ok:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(j);
                if (j == 5) {
                    break ok;
                }
            }
        }
        Thread.sleep(5);
    }

    /**
     * 这段代码在jdk1.6中运行，会得到两个false，而在jdk1.7中运行会得到一个true一个false。产生差异的原因是：在jdk1.6中，intern()
     * 方法会把首次遇到的字符串实例复制到永久代中，返回的也是永久代中这个字符串实例的引用，而用StringBuilder创建的字符串实例在Java堆上，所以必然不是同一个引用，将返回false。而jdk1.7中的intern
     * ()实现不会再复制实例，只是在常量池中记录首次出现的实例引用，因此intern()
     * 返回的引用和由StringBuilder创建的那个字符串实例是同一个。对比str2返回false是因为“java”这个字符串在执行StringBuilder.toString()
     * 之前已经出现过，字符串常量池中已经有它的引用了，不符合首次出现的原则，而“good”这个字符串则是首次出现的，因此返回true。
     * 现在的疑问是“java”这个字符串在常量池中什么时候存在了？
     * 我最开始的猜想是“java”这个字符串是不是常驻在常量池中的？那为什么常驻在常量池中呢？Java虚拟机什么时候加载了“java”这个字符串？
     * 答：java虚拟机会自动调用System类，代码如下：
     * ————————————————
     */
    @Test
    public void test1111() {
        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }

    @Test
    public void testjisuan() {
        // 左移3位相当于乘以2的3次方，右移3位相当于除以2的3次方
        System.out.println(3 << 3);
    }

    @Test
    public void test123() {
        String a = new String("lzy");
        // String b = a.intern();
        // System.out.println(b);
        //
        // StringBuilder s = new StringBuilder("1223");
        // System.out.println(s.reverse());
        System.out.println(a.substring(1));
        Set<String> set = new HashSet<>();
        set.add("1");

    }

    @Test
    public void testA() {
        List<String> list = new ArrayList<>();
        list.sort((o1, o2) -> Integer.parseInt(o1.length() > o2.length() ? o1 : o2));
        Map<String, List> map = new HashMap<>();
    }

    @Test
    public void test1111111() {
        StringBuffer abc = new StringBuffer("abc");
        StringBuffer abc1 = new StringBuffer("abc");
        System.out.println(abc.equals(abc1));

        StringBuilder builder = new StringBuilder("123");
        StringBuilder builder1 = new StringBuilder("123");
        System.out.println(builder.equals(builder1));
    }

    @Test
    public void testlzyi() throws IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException {
        Class<Person> aClass = Person.class;
        Person person = aClass.newInstance();
        Class<? extends Person> aClass1 = person.getClass();
        Constructor<Person> constructor = aClass.getConstructor();

        constructor.setAccessible(true);
        Person person1 = constructor.newInstance(Person.class);
    }

    @Test
    public void testzifuchuan() {
        String s = "asdfg";
        int length = s.length();
        String reverse = "";
        for (int i = 0; i < length; i++) {
            reverse = s.charAt(i) + reverse;
        }
        System.out.println(reverse);
    }

    @Test
    public void testllll() {
        // System.out.println(Runtime.getRuntime().availableProcessors());
        int n = 123;
        int m = 0, a = 1;
        for (int i = 9; i > 1; i--) {
            if (n % i == 0) {
                m = m + i * a;
                n /= i;
                i = 10;
                a *= 10;
            }
        }
        if (n != 1) {
        }
        System.out.println(m);
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

    }

    @Test
    public void testadd() {
        String name = "name";
        System.out.println(String.class.isInstance(name));

    }

    /**
     * 测试List固定大小并且已满的情况
     * 会扩容
     */
    @Test
    public void testListFull() throws NoSuchFieldException, IllegalAccessException {
        List<String> list = new ArrayList<>(5);
        for (int i = 0; i < 6; i++) {
            list.add("data" + i);
        }
        //可以在这里的构造函数来进行ArrayList初始容量的设定
        Class<? extends List> strClass = list.getClass();
        Field field = strClass.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(list);
        System.out.println("这个ArrayList的容量为："+elementData.length+
                ",这个ArrayList中元素的个数为"+list.size());
        // 扩容了1.5倍
        list.forEach(System.out::println);
    }

    /**
     * subList硬核分页
     */
    @Test
    public void testSubListPage(){
        List<String> list = new ArrayList<>(5);
        int start = 10;
        int end = 66;
        int fetchSize = (end - start) / 5;
        for (int startT = start; startT < end; startT += fetchSize) {
            int endT = startT + fetchSize;
            System.out.println("查询范围为：" + startT + " ==> " + endT);
            list.add("data" + startT);
        }
        System.out.println(list.size());
    }

    @Test
    public void testLombok() throws Exception {
        try {
            System.out.println(2/0);
        } catch (Exception e) {
            // throw 异常报错
            // throw new Exception("sss");
            System.out.println("22");
        }
    }

    @Test
    public void testCompareTo(){
        String s1 = "my";
        String s2 = "qi";
        int i = s1.compareTo(s2);
        System.out.println(i);
    }

}

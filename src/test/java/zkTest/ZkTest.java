package zkTest;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import entity.BigStudent;
import entity.Person;
import entity.SerStudent;
import entity.Student;
import okhttp3.*;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        int a = 5;
        int b = 3;
        System.out.println(a | b);
        System.out.println(a & b);
        System.out.println(a ^ b);
        // System.err.println(a |= b);
        // System.err.println(a &= b);
        // System.err.println(a ^= b);

    }

    @Test
    public void test111(){
        System.out.println(20>>6);
    }

    @Test
    public void testAi(){
        Integer i = null;
        int x = i.intValue();
        System.out.println(x);
        StringJoiner joiner = new StringJoiner("hello");
        joiner.add("ss");
        joiner.add("sssssss");
        System.out.println(joiner.toString());

    }

    @Test
    public void testRegex(){
        // regex匹配邮箱
        Pattern pattern = Pattern.compile("^.+@.+$");
        Matcher asdasd = pattern.matcher("810230865@qq.com");
        System.out.println(asdasd);
    }

    /**
     * Optional测试
     *
     */
    @Test
    public void testOptional(){
        Person person = new Person();
        person = null;

        Person person1 = Optional.ofNullable(person).orElseGet(() -> {
            System.out.println("1111");
            return new Person("111");
        });
        System.out.println(person1);

    }

    @Test
    public void testForEachOrdered(){
        List<String> list = Lists.newArrayList("C","A", "B");
        // list.forEach(System.out::println);
        // System.err.println("===================");
        list.stream().forEachOrdered(System.out::println);
        list.stream().sorted((o1, o2) -> 0);
    }

    /**
     * 测试比较器
     */
    @Test
    public void testComparator(){
        BigStudent bigStudent = new BigStudent("lzy", 3);
        BigStudent bigStudent1 = new BigStudent("lzy2", 1);
        BigStudent bigStudent2 = new BigStudent("lzy3", 5);
        List<BigStudent> list = Lists.newArrayList(bigStudent, bigStudent1, bigStudent2);
        BigStudent bigStudent3 = list.stream().sorted(new Comparator<BigStudent>() {
            @Override
            public int compare(BigStudent o1, BigStudent o2) {
                return o2.getAge() - o1.getAge();
            }
        }).findFirst().get();
        System.out.println(bigStudent3);
    }

    /**
     *  List通过stream转Map
     *
     */
    @Test
    public void testListToMap(){
        BigStudent bigStudent = new BigStudent("lzy", 3);
        BigStudent bigStudent1 = new BigStudent("lzy2", 1);
        BigStudent bigStudent2 = new BigStudent("lzy3", 5);
        List<BigStudent> list = Lists.newArrayList(bigStudent, bigStudent1, bigStudent2);
        Map<Integer, BigStudent> collect = list.stream().collect(Collectors.toMap(BigStudent::getAge,
                bigStudent3 -> bigStudent3));
        // collect.forEach((k,v)-> System.out.println("key: " + k + "   value:" + v));
        Map<Integer, BigStudent> sortedKeyMap = collect.entrySet().stream()
                .sorted(Map.Entry.<Integer, BigStudent>comparingByKey().reversed())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                // 相同key的合并规则
                                (oldVal, newVal) -> oldVal,
                                // 指定生成的Map类型
                                LinkedHashMap::new
                        )
                );
        sortedKeyMap.forEach((k,v)-> System.out.println("key: " + k + "   value:" + v));
    }

    /**
     * <p>
     *     {@code List<Map<String, Object>>}转{@code Map<String, List<Map<String, Object>>>}
     * </p>
     */
    @Test
    public void testListToBigMap(){
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();
        Map<String, Object> map4 = new HashMap<>();
        Map<String, Object> map5 = new HashMap<>();
        map.put("serverName", "svc-aompsuanfarongqiyanshi-86");
        map.put("id", "instance.mem.free");
        map.put("value", 1.69);

        map1.put("serverName", "svc-aompsuanfarongqiyanshi-86");
        map1.put("id", "instance.mem.total");
        map1.put("value", 2.07);

        map2.put("serverName", "svc-aompsuanfarongqiyanshi-91");
        map2.put("id", "instance.mem.free");
        map2.put("value", 3);

        map3.put("serverName", "svc-aompsuanfarongqiyanshi-91");
        map3.put("id", "instance.mem.total");
        map3.put("value", 2.07);

        map4.put("serverName", "svc-aompsuanfarongqiyanshi-89");
        map4.put("id", "instance.mem.free");
        map4.put("value", 1.08);

        map5.put("serverName", "svc-aompsuanfarongqiyanshi-89");
        map5.put("id", "instance.mem.total");
        map5.put("value", 2.07);
        List<Map<String, Object>> container = Lists.newArrayList(
                map, map1, map2, map3, map4, map5
        );

        // List转Map老办法
        Map<String, List<Map<String, Object>>> bigMap = new HashMap<>();
        for (Map<String, Object> stringObjectMap : container) {
            List<Map<String, Object>> list = bigMap.get(stringObjectMap.get("serverName"));
            if (list == null) {
                list = new ArrayList<>();
                bigMap.put(stringObjectMap.get("serverName").toString(), list);
            }
            list.add(stringObjectMap);
        }
        // 新办法(暂时找不到)
    }

    @Test
    public void testaa() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String mapping = "{\"properties\": {\"id\": {\"type\": \"keyword\"},\"tags\": {\"type\": \"keyword\"}," +
                "\"serverName\": {\"type\": \"keyword\"},\"time\": {\"type\": \"date\"},\"value\": {\"type\": " +
                "\"float\"}}}";
        // System.out.println(mapping);
        final Request request = new Request.Builder()
                .url("http://172.17.1.40:9200/lookout-active-test-metricsl/metrics/_mapping")
                .put(RequestBody.create(MediaType.parse("application/json"), mapping.getBytes(StandardCharsets.UTF_8)))
                .build();
        Response execute = client.newCall(request).execute();
        System.out.println(execute.body().toString());
    }

    /**
     * 序列化测试
     *
     */
    @Test
    public void testJSON() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\temp.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // Student没有序列化
        Student student = new Student();
        student.setDate(new Date());
        student.setName("111");
        oos.writeObject(student);
        oos.flush();
        oos.close();
    }

    /**
     * 序列化
     *
     */
    @Test
    public void testSer() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\temp1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        SerStudent serStudent = new SerStudent();
        // 序列化
        serStudent.setDate(new Date());
        serStudent.setName("lzy");
        oos.writeObject(serStudent);
        oos.flush();
        oos.close();
    }

    /**
     * 反序列化
     *
     */
    @Test
    public void testSerEx() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("D:\\temp.txt");
        ObjectInputStream oin = new ObjectInputStream(fis);
        Student student = ((Student) oin.readObject());
        System.out.println(student.getDate());
    }


}

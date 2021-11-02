package zkTest;

import aenum.Color;
import aenum.MyEnum;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import entity.*;
import juc.function.User;
import okhttp3.*;
import org.junit.Test;
import org.springframework.util.StringUtils;
import zkTest.collection.DataAccess;
import zkTest.domain.TaskInspectDTO;
import zkTest.domain.TerminalMessage;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.ToLongFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        Double d = sheep.getLzyTest(12d);
        System.out.println(d);
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
        Map<String, Object> map6 = new HashMap<>();
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

    /**
     * 测试okHttp
     *
     * @throws IOException IOException
     */
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

    @Test
    public void testStringFormat(){
        // 丢失精度
        BigDecimal bigDecimal1 = new BigDecimal(0.11d);
        BigDecimal bigDecimal = BigDecimal.valueOf(0.11d);
        System.out.println(bigDecimal1);
        System.out.println(bigDecimal);
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

    @Test
    public void testLzy(){
        // 字符串转List
        String s = "a,b,c";
        List<String> strings = Splitter.on(",").splitToList(s);
        strings.forEach(System.out::println);
        // List转字符串
        String join = Joiner.on("-").join(strings);
        System.out.println(join);
    }

    @Test
    public void testlzy(){
        DecimalFormat decimalFormat = new DecimalFormat("##.0000%");
        // System.out.println((double) (Integer.parseInt("1122") / 1800));
        System.out.println(Double.parseDouble(decimalFormat.format(Integer.parseInt("1122") / 1800)));
    }

    @Test
    public void testENUM(){
        System.out.println(Color.RED.name());
    }

    @Test
    public void testSOUT(){
        String TABLE_TYPE_DOC =
                "By default, the JDBC connector will only detect tables with type TABLE from the source "
                        + "Database. This config allows a command separated list of table types to extract. Options"
                        + " include:\n"
                        + "  * TABLE\n"
                        + "  * VIEW\n"
                        + "  * SYSTEM TABLE\n"
                        + "  * GLOBAL TEMPORARY\n"
                        + "  * LOCAL TEMPORARY\n"
                        + "  * ALIAS\n"
                        + "  * SYNONYM\n"
                        + "  In most cases it only makes sense to have either TABLE or VIEW.";
        System.out.println(TABLE_TYPE_DOC);
    }

    @Test
    public void testJSONObject(){
        String[] split = StringUtils.split("OD_GENERATE|2.0.0", "|");
        String codeKeyPrefix = split[0];
        System.out.println(codeKeyPrefix);

        String s = "ALGORITHM:MODULE:svc-aompquanxilukourongqi-91:OD_GENERATE|2.0.0";
        String[] split1 = s.split(":");
        System.out.println(Arrays.toString(split1));
    }

    @Test
    public void testStr(){
        List<User> list = Lists.newArrayList(
                new User(5, "lzy", 22),
                new User(2,"222", 12),
                new User(3, "333", 33),
                new User(3, "111", 111)
        );
        Map<Integer, List<User>> collect = list.stream().collect(Collectors.groupingBy(User::getId));
        collect.forEach((k,v) -> {
            System.out.println(k + "==========" + v);
        });
        for (Map.Entry<Integer, List<User>> entry : collect.entrySet()) {
            List<User> value = entry.getValue();
            System.out.println(value.size());
        }
    }

    @Test
    public void testSwitch(){
        System.out.println(Calendar.getInstance());
        List<DataAccess> countList = Lists.newArrayList(
                new DataAccess("name", "20210903", 88f),
                new DataAccess("age", "20210903", 85f),
                new DataAccess("name", "20210902", 90f),
                new DataAccess("age", "20210902", 70f)
        );
        // key为日期, value为List<DataAccess>
        Map<String, List<DataAccess>> map = new HashMap<>();
        Map<String, List<DataAccess>> collect =
                countList.stream().collect(Collectors.groupingBy(DataAccess::getReportDate));
        collect.forEach((k, v) -> {

        });
    }

    @Test
    public void testSourceSink(){
        List<String> list = Lists.newArrayList("sink:global-search-user_log_info1",
                "source:its-http-test",
                "source:global-search-chongqing_company",
                "source:global-search-employee2",
                "sink:global-search-employee2",
                "source:global-search-employee1",
                "sink:global-search-employee1",
                "sink:global-search-chongqing_vehicle",
                "sink:global-search-chongqing_company",
                "source:global-search-chongqing_vehicle",
                "source:global-search-user_log_info1");
        Map<String, TaskInspectDTO> collect = list.stream().map(name -> name.replaceFirst("^(source:|sink:)", ""))
                .collect(Collectors.toSet())
                .stream()
                .collect(Collectors.toMap(name -> name, TaskInspectDTO::new));
        collect.forEach((k, v) -> {
            System.out.println("name: " + k);
            System.out.println("value: " + v);
        });
    }

    @Test
    public void testLocalDate() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        Map<String, String> map2 = new HashMap<>();
        map2.put("3", "3");
        Map<String, String> allMap = new HashMap<>();
        allMap.putAll(map);
        allMap.putAll(map2);
        allMap.forEach((k,v) -> {
            System.out.println("key : " + k + ", value : " + v
            );
        });
    }

    @Test
    public void testMAPRemove(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "666");
        map.put("2", "266");
        System.out.println("被删除的key的value为：" + map.remove("3"));
        map.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
    }

    @Test
    public void testCompare(){
        EntityAge one = new EntityAge("lzy", 22);
        EntityAge two = new EntityAge("poi", 24);
        EntityAge three = new EntityAge("hhh", 13);
        List<EntityAge> list = Lists.newArrayList(one, two, three);
        List<EntityAge> collect = list.stream().sorted(new Comparator<EntityAge>() {
            @Override
            public int compare(EntityAge o1, EntityAge o2) {
                return o2.getAge() - o1.getAge();
            }
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void test123(){
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(Float.parseFloat("100")));

    }

    @Test
    public void testRandom(){
        Map<String, Object> map = Maps.newHashMap();
        Random random = new Random();
        map.put("name" + random.nextInt(3), "test");
        map.put("age" + random.nextInt(3), new Random().nextInt(40));
        map.put("hobby" + random.nextInt(3), new Random().nextInt(40));
        map.forEach((k, v) -> {
            System.out.println(k + "   " + v);
        });


        // Random random = new Random(100);
        // System.out.println(random.nextInt(3));
    }

    @Test
    public void testRegex1(){
        Map<String, Object> map1 = Maps.newHashMap();
        map1.put("1", "1");
        Map<String, Object> map2 = Maps.newHashMap();
        map2.put("1", "2");
        Map<String, Object> finalCOnf = Maps.newHashMap();
        finalCOnf.putAll(map1);
        finalCOnf.putAll(map2);
        finalCOnf.forEach((k, v) -> {
            System.out.println(k + v);
        });
    }


    @Test
    public void testJsonObject(){
        List<String> list = Lists.newArrayList(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30"
        );
        int index = (list.size() / 7) - 1;
        List<String> result = Lists.newArrayList();
        for (int i = index; i < list.size(); i++) {
            result.add(list.get(i));
            i = i + index;
        }
        result.forEach(System.out::println);
    }

    @Test
    public void testArith(){
        List<RuleAssign> list = Lists.newArrayList(
                new RuleAssign(1, "a", "1001"),
                new RuleAssign(2, "b", "1002"),
                new RuleAssign(3, "c", "1003"),
                new RuleAssign(4, "a", "1001")
        );
        // 多字段联合校验 rule和type
        Set<RuleAssign> set = new TreeSet<>(Comparator.comparing(RuleAssign::getRule)
                .thenComparing(RuleAssign::getType));
        set.addAll(list);
        if (set.size() < list.size()) {
            System.out.println("rule 在list中不唯一");
        }
    }

    @Test
    public void testSplit(){
        String className = "com.supconit.its.kafka.connect.datahub.datahubSourceConnector";
        String[] split = className.split("\\.");
        System.out.println(split[split.length - 1]);
    }

    @Test
    public void testIntegerValueOf() {
        List<LongValue> longValueList = Lists.newArrayList(
                new LongValue("1", 1635383888071L),
                new LongValue("2", 1635383888073L),
                new LongValue("3", 1635383888072L)
        );

        List<LongValue> collect =
                longValueList.stream().sorted(Comparator.comparingLong(LongValue::getTimestamp).reversed()).collect(Collectors.toList());
        collect.forEach(System.out::println);

        // System.err.println(timestamp);
    }

    @Test
    public void testTime() throws ParseException {
        Map<String, Object> map = new HashMap<>();
        // todo
        // map.merge()
    }

    /**
     * 不安全的原始类型
     * （关于泛型的类型擦除）
     */
    public static void add(List list, Object o){
        list.add(o);
    }
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        add(list, 10);
        String s = list.get(0);
    }

}
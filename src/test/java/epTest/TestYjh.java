package epTest;

import org.junit.Test;
import resume.Person;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author linzy
 * @create 2020-12-16 10:42:38
 */

public class TestYjh {

    @Test
    public void testForListModCount(){

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if ("5".equals(s)) {
                list.remove(s);
            } else {
                System.out.println(s);
            }
        }
        System.out.println(list);
    }

    @Test
    public void test(){
        Random random = new Random(1);
        int i = random.nextInt(200);
        int j = random.nextInt(200);

    }

    // 测试在集合中寻找最大的东西😊
    @Test
    public void testMax(){
        // List<String> list = new ArrayList<>();
        // list.add("1");
        // list.add("3");
        // list.add("2");
        // list.add("4");
        // list.add("5");
        // Collections.sort(list);
        // String max = Collections.max(list);
        // System.out.println(max);
        // list.forEach(System.out::println);

        List<Person> list2 = new ArrayList<>();
        list2.add(new Person("lzy0", "22"));
        list2.add(new Person("lzy1", "21"));
        list2.add(new Person("lzy2", "23"));
        list2.add(new Person("lzy3", "26"));
        Optional<Person> max1 = list2.stream().max(Comparator.comparing(Person::getAge));
        System.out.println(max1.get().getName());
    }

    @Test
    public void testForSteam(){
        List<String> list = new ArrayList<>();
        list.add("3");
        list.add("1");
        list.add("2");
        list.add("4");
        list.add("5");
        List<Integer> asList = Arrays.asList(1, 3, 4, 2, 5, 6, 7, 8);
        // System.out.println(asList.stream().reduce(Integer::sum).get());
        //所有数乘积的两倍
        // System.out.println(asList.stream().reduce(2, (a, b) -> (a * b)));
        List<Integer> collect = list.stream().map((Integer::parseInt)).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }

    @Test
    public void testThreadArray(){
        System.out.println("testArray start....");
        Runnable runnable = () -> {
            System.out.println("run!!");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hhhhhh!!");
        };
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("testArray end!!");

    }

    @Test
    // 找到接下来30天的周末
    public void testForFilter() {

        Stream.generate(new DateSupplier())
                .limit(31)
                .filter(d -> d.getDayOfWeek() == DayOfWeek.SATURDAY || d.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(System.out::println);
    }

    static class DateSupplier implements Supplier<LocalDate> {

        LocalDate start = LocalDate.now();
        int n = -1;

        @Override
        public LocalDate get() {
            n++;
            return start.plusDays(n);
        }
    }

    @Test
    public void testForMapAndReduce(){
        List<String> list = new ArrayList<>();
        list.add("name=lzy");
        list.add("debug=true");
        list.add("help=false");
        // 把k=v转换为Map[k]=v
        Stream<String[]> stream = list.stream().map(kv -> {
            String[] ss = kv.split("\\=", 2);
            for (String s : ss) {
                System.out.println(s);
            }
            return ss;
        });
        stream.forEach(System.out::println);
    }

    @Test
    public void test1(){
        String s = "name=lzy=qwewer=werwer";
        // 会切割两次
        String[] split = s.split("\\=", 3);
        System.out.println(Arrays.toString(split));
    }

    @Test
    public void testForToArray(){
        List<String> list = new ArrayList<>();
        list.add("lzy");
        list.add("qwe");
        list.add("rty");
        String[] strings = list.stream().toArray(String[]::new);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void testForToMap(){
        Stream<String> stream = Stream.of("APPL:Apple", "MSFT:Microsoft");
        Map<String, String> map = stream
                .collect(Collectors.toMap(
                        // 把元素s映射为key:
                        s -> s.substring(0, s.indexOf(':')),
                        // 把元素s映射为value:
                        s -> s.substring(s.indexOf(':') + 1)));
        System.out.println(map);
    }

    @Test
    public void testStu(){
        Stream<Student> studentStream = Stream.of(
                new Student(2, 3, "小明", 80),
                new Student(3, 1, "小王", 90),
                new Student(1, 2, "小强", 100),
                new Student(3, 1, "小红", 90),
                new Student(1, 2, "小黄", 100),
                new Student(2, 3, "小黑", 80),
                new Student(1, 2, "小军", 100),
                new Student(2, 3, "小乔", 80),
                new Student(3, 1, "小林", 90));


        Map<Integer, Map<Integer, List<Student>>> studentByGradeAndClass =
                studentStream.collect(Collectors.groupingBy(Student::getGradeId, Collectors.groupingBy(Student::getClassId)));
        studentByGradeAndClass.forEach((k, m) -> {
            System.out.print("Grade" + k + " ");
            m.forEach((key, value) -> {
                System.out.println("Class" + k + "=" + value);
            });
        });

    }

    class Student {
        private int gradeId;
        private int classId;
        private String name;
        private int score;

        public Student(int gradeId, int classId, String name, int score) {
            this.gradeId = gradeId;
            this.classId = classId;
            this.name = name;
            this.score = score;
        }

        public int getGradeId() {
            return gradeId;
        }

        public int getClassId() {
            return classId;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "Name:" + getName() + " " + "Score: " + getScore();
        }
    }

}
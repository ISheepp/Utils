import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

    // 返回一个对象
    @org.junit.Test
    public void jacksonTest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Person person = new Person("林子洋", 22, "male");

        String s = mapper.writeValueAsString(person);
        System.out.println(s);
    }

    // 返回多个对象
    @org.junit.Test
    public void jacksonTest2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        List<Person> list = new ArrayList<Person>();

        Person person = new Person("林子洋", 22, "male");
        Person person2 = new Person("林子洋2", 21, "male2");
        Person person3 = new Person("林子洋3", 21, "male3");

        list.add(person);
        list.add(person2);
        list.add(person3);

        String s = mapper.writeValueAsString(list);
        System.out.println(s);

    }

    // json工具类测试
    @org.junit.Test
    public void test1() throws JsonProcessingException {
        Date date = new Date();
        System.out.println(JsonUtil.getJson(date));
    }

    @org.junit.Test
    public void test2(){
        Person person = new Person("lzy", 22, "男");
        System.out.println(person.toString());
    }

}

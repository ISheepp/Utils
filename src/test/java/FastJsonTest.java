import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;



/**
 * @Author ISheep
 * @Date 2020/9/29 20:05
 * @Version 1.0
 */
public class FastJsonTest {

    @Test
    public void test(){


        Person person = new Person("林子洋", 22, "male");
        // Java对象直接转Json
        String s = JSON.toJSONString(person);
        System.out.println(s);

        String json = "{\n" +
                "  " +
                "\"name\": \"林子洋\",\n" +
                "  \"age\": 22,\n" +
                "  \"sex\": \"male\"\n" +
                "}";

        // json转java对象
        Person person1 = JSONObject.parseObject(json, Person.class);

        System.out.println(person1);

    }

    @Test
    public void test3(){

    }

}

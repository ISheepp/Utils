package zkTest.fastjson;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author 林子洋
 * @create 2021-11-19 16:27:03
 */
public class TestValue {

    @Test
    public void test(){
        Status status = Status.create(10);
        String s = JSON.toJSONString(status);
        System.out.println(s);
    }

}

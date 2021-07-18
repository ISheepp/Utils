package lzyTest;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 林子洋
 * @create 2021-07-05 16:56:13
 */
public class TestLists {

    @Test
    public void test(){
        FileBO bo = new FileBO();
        bo.setGroup("default");
        bo.setPath("/upload");
        FileBO boe = new FileBO();
        boe.setGroup("select");
        boe.setPath("/poi");
        List<FileBO> list = Lists.newArrayList(bo);
        String x = JSON.toJSONString(list);
        System.out.println(x);


        List list1 = (List) JSON.parse(x);
        // List<FileBO> fileBOS = new ArrayList<>();
        // list1.forEach(System.err::println);
        // for (Object o : list1) {
        //     FileBO fileBO = JSON.parseObject(o.toString(), FileBO.class);
        //     fileBOS.add(fileBO);
        // }
        // fileBOS.forEach(System.out::println);
    }

}

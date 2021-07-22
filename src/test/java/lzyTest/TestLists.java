package lzyTest;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.thread.ThreadFactoryBuilder;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author 林子洋
 * @create 2021-07-05 16:56:13
 */
public class TestLists {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNamePrefix("demo-pool-%d").build();

    private static ExecutorService pool = new ThreadPoolExecutor(5, 100, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<>(128), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

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
        List<FileBO> fileBOS = new ArrayList<>();
        list1.forEach(System.err::println);
        for (Object o : list1) {
            FileBO fileBO = JSON.parseObject(o.toString(), FileBO.class);
            fileBOS.add(fileBO);
        }
        fileBOS.forEach(System.out::println);
    }

    @Test
    public void test222(){
        List<SortBo> list = Lists.newArrayList(new SortBo(4), new SortBo(2));
        list.forEach(System.err::println);
        List<SortBo> collect = list.stream().sorted(Comparator.comparing(SortBo::getSort)).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void testStringFormat() {
        String str = String.format("asdasd + %s", "22");
        // String sql = "SELECT table_name,data_base,data_size,index_size,CONCAT( TRUNCATE ( ( data_size + index_size ), 2 ) ) AS total_size  FROM (" +
        //         "SELECT table_name, TABLE_SCHEMA AS data_base,group_concat( TRUNCATE ( data_length / 1024 / 1024, 2 )) AS data_size," +
        //         "group_concat( TRUNCATE ( index_length / 1024 / 1024, 2 ) ) AS index_size FROM information_schema.TABLES  GROUP BY table_name,data_base ) t where data_base NOT in( 'sys','mysql','`performance_schema`','information_schema')";
        // System.out.println(sql);
        // System.out.println(str);

        List<String> list = Lists.newArrayList("111", "222", "333");
        for (String s : list) {
            System.out.println(s);
        }
        Map<String, Object> map = Maps.newHashMap();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.forEach((k, v) -> System.out.println(k + "=====" + v));



    }

}

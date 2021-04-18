package juc.unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author linzy
 * @create 2021-03-02 21:23:55
 */
public class MapTest {

    public static void main(String[] args) {
        // Map<String, String> map = new HashMap<>();
        // // 加载因子0.75 初始容量16
        // for (int i = 0; i < 30; i++) {
        //     new Thread(()->{
        //         map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
        //         System.out.println(map);
        //     }, String.valueOf(i)).start();
        // }
        Map<String, Object> map = new ConcurrentHashMap<>();


    }
}

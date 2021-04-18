package sync;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linzy
 * @create 2021-02-28 15:13:14
 * 线程不安全的集合
 */
public class UnsafeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                // list是被多个线程操作的共享对象
                synchronized (list) {
                    list.add(Thread.currentThread().getName() + "lzy");
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

}

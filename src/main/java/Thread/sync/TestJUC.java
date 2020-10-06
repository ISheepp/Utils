package Thread.sync;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lin
 * @create 2020-10-06 10:59
 */

//测试JUC安全类型的集合
public class TestJUC {
    public static void main(String[] args) throws InterruptedException {
        //线程安全的List
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }

        Thread.sleep(3000);
        System.out.println(list.size());

    }
}

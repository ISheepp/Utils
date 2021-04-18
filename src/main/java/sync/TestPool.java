package sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author linzy
 * @create 2021-02-28 19:04:26
 */
public class TestPool {
    public static void main(String[] args) {
        // 1. 创建线程池,10为线程池大小
        ExecutorService service = Executors.newFixedThreadPool(10);
        // 执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        // 关闭连接
        service.shutdown();
    }


}

class MyThread implements Runnable {
    @Override
    public void run() {

            System.out.println(Thread.currentThread()
            .getName());

    }
}

package juc.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author linzy
 * @create 2021-03-03 22:06:07
 */
public class Pool2 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        // 自定义线程池, 2个核心窗口，3个座位（阻塞队列），总共5个窗口，3s后没人进来就关闭多余的窗口
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
                                                        // AbortPolicy: 银行满了，还有人进来，不处理这个人，抛出异常
                                                        // CallerRunsPolicy: 哪儿来的去哪里，下面是main线程，不会抛出异常
                                                        // DiscardPolicy: 队列满了，丢掉任务，不会抛出异常
                                                        // DiscardOldestPolicy: 队列满了，尝试去和最早的竞争，竞争失败还是丢掉，不会抛出异常
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + "   OK"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

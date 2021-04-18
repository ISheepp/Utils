package juc.one;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author linzy
 * @create 2021-02-26 20:26:03
 */
public class MyThreadPool {

    private static ExecutorService executorService = new ThreadPoolExecutor(1, 50, 60, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(200));

    static class Work implements Runnable {
        @Override
        public void run() {
            System.out.println("=====call work======");
        }
    }

    public static void main(String[] args) {
        try {
            executorService.submit(new MyThreadPool.Work());
        } finally {
            executorService.shutdown();
        }
    }

}

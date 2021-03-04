package juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author linzy
 * @create 2021-03-03 21:24:39
 */


public class Pool {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();// 单个线程
        // ExecutorService threadPool = Executors.newFixedThreadPool(5);// 创建一个固定的线程池大小
        // ExecutorService threadPool = Executors.newCachedThreadPool();// 可伸缩的，

        try {
            for (int i = 0; i < 20; i++) {
                // 使用线程池创建线程
                threadPool.execute(()-> System.out.println(Thread.currentThread().getName() + " OK"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }


    }
}

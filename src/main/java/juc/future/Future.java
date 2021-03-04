package juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author linzy
 * @create 2021-03-04 21:56:05
 * 1、异步执行
 * 2、成功回调
 * 3、失败回调
 *
 */
public class Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "runAsync=>Void");
        });

        System.out.println("111");
        completableFuture.get();

    }
}

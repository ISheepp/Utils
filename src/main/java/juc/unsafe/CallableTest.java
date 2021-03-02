package juc.unsafe;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author linzy
 * @create 2021-03-02 21:34:38
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new MyThread());
        // task.run();
        new Thread(task, "A").start();
        new Thread(task, "B").start();
        String o = ((String) task.get()); // get方法可能产生阻塞
        // Callable会产生缓存提高效率，也就是说两次start会执行一次
        // 使用异步通信来处理
        System.out.println(o);
    }

}

class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("123");
        return "1111111111111";
    }
}

package juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author linzy
 * @create 2021-03-02 20:22:18
 * 关于锁的8个问题
 * 1、标准情况下，两个线程先打印发短信还是打电话
 * 1、sendSms延迟4秒，两个线程先打印发短信还是打电话
 */
public class Test1 {

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendSms();
        }, "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone.call();
        }, "B").start();
    }

}

class Phone {

    // 被synchronized 所得对象是方法的调用者
    // 两个方法都是phone调用，谁先拿到锁就先执行
    public synchronized void sendSms() {

        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }
}

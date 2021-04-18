package juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author linzy
 * @create 2021-03-02 20:29:09
 * 3、增加一个普通方法后，就是普通方法限执行（没有锁就不受锁的影响）
 * 4、**两个**对象，两个同步方法，不一定
 * 5、静态方法类一加载就有了，锁的是Class类模板
 */

public class Test2 {

    public static void main(String[] args) {
        Phone3 phone = new Phone3();
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

class Phone3 {

    // 被synchronized 所得对象是方法的调用者
    // 两个方法都是phone调用，谁先拿到锁就先执行
    public static synchronized void sendSms() {

        System.out.println("发短信");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }
}

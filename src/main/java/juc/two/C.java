package juc.two;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author linzy
 * @create 2021-03-02 20:09:35
 * 循环打印ABC ABC....
 * A执行完调用B,B执行完调用C，C执行完调用A
 */
public class C {

    public static void main(String[] args) {

        Data3 data = new Data3();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        }, "B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        }, "C").start();
    }

}

//资源类
class Data3 {

    private final Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    private int number = 1;   //1A   2B   3C

    public void printA() {
        lock.lock();
        try {
            // 业务，判断-> 执行-> 通知
            while (number != 1) {
                // 等待
                condition1.await();
            }
            // System.out.println(Thread.currentThread().getName() + "=>AAAAAA");
            System.out.println("A");
            // 唤醒指定B
            // condition1.signalAll();// 通知全部
            number = 2;
            condition2.signal(); // 唤醒指定
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void printB() {
        lock.lock();
        try {
            // 业务，判断-> 执行-> 通知
            while (number != 2) {
                // 等待
                condition2.await();
            }
            // System.out.println(Thread.currentThread().getName() + " => AAAAAA");
            System.out.println("B");
            // 唤醒指定B
            // condition1.signalAll();// 通知全部
            number = 3;
            condition3.signal(); // 唤醒指定
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            // 业务，判断-> 执行-> 通知
            while (number != 3) {
                // 等待
                condition3.await();
            }
            // System.out.println(Thread.currentThread().getName() + "=>AAAAAA");
            System.out.println("C");
            // 唤醒指定B
            // condition1.signalAll();// 通知全部
            number = 1;
            condition1.signal(); // 唤醒指定
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

package juc.two;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author linzy
 * @create 2021-02-28 21:15:17
 */
public class B {

    // 判断等待，业务，通知
    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }

}

class Data2 {
    private int number = 0;

    Lock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    // +1
    public void increment() throws InterruptedException {

        lock.lock();
        // if会造成虚假唤醒
        // if (number != 0) {
        //     // 等待
        //     this.wait();
        // }
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            // 通知其他线程，我+1完毕了
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // -1
    public synchronized void decrement() throws InterruptedException {
        // if (number == 0) {
        //     // 等待
        //     this.wait();
        // }
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        // 通知其他线程，我-1完毕了
        this.notifyAll();
    }

}

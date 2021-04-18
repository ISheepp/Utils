package juc.lock8;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author linzy
 * @create 2021-03-06 14:14:02
 * 自旋锁
 */
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    // 加锁
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==> myLock");

        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    // 解锁
    public void myUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==> myUnLock");
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) {

    }

}

package juc.lock8;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author linzy
 * @create 2021-03-06 14:16:58
 */
public class TestSpinLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();

        // 底层使用的CAS 做出自己的锁
        SpinLockDemo lockDemo = new SpinLockDemo();
        lockDemo.myLock();
        lockDemo.myUnLock();
    }
}

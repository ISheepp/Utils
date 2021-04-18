package juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author linzy
 * @create 2021-03-04 23:00:19
 */
public class Vdemo {

    private volatile static AtomicInteger num = new AtomicInteger();

    public static void main(String[] args) {
        num.getAndIncrement(); // +1方法 CAS
    }
}

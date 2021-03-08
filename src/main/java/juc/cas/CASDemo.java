package juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author linzy
 * @create 2021-03-06 12:51:58
 */
public class CASDemo {

    // CAS

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2021);
        // 比较并交换
        // public final boolean compareAndSet(int expect, int update)
        // 如果我期望的值达到了就更新，否则就不更新,CAS是CPU的并发原语

        // =====================
        System.out.println(atomicInteger.compareAndSet(2021, 2022));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2022, 2021));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021, 6666));
        System.out.println(atomicInteger.get());

    }
}

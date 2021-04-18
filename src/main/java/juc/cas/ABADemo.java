package juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author linzy
 * @create 2021-03-06 13:22:02
 */
public class ABADemo {
    public static void main(String[] args) {
        // 第二个参数版本号，每次修改就会加一
        AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference<>(2020, 1);

        new Thread(()->{
            int stamp = atomicInteger.getStamp(); // 获得版本号
            System.out.println("a1=> " + stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicInteger.compareAndSet(2020, 2022, atomicInteger.getStamp(), atomicInteger.getStamp() + 1);
            System.out.println("a2=> " + stamp);
            atomicInteger.compareAndSet(2020, 2022, atomicInteger.getStamp(), atomicInteger.getStamp() + 1);
        },"a").start();

        new Thread(()->{
            int stamp = atomicInteger.getStamp(); // 获得版本号
            System.out.println("b1=> " + stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicInteger.compareAndSet(2020, 6666, stamp, stamp + 1);

            System.out.println(atomicInteger.getStamp());
        },"b").start();
    }
}

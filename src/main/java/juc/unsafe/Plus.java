package juc.unsafe;

import java.util.concurrent.CyclicBarrier;

/**
 * @author linzy
 * @create 2021-03-02 22:29:50
 */
public class Plus {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(7, () -> {
            System.out.println("哈哈哈");
        });
        for (int i = 0; i <= 7; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "收集了" + finalI + "龙珠");
            });

        }

    }
    
}

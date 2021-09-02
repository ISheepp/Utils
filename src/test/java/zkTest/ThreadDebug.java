package zkTest;

import java.util.concurrent.TimeUnit;

/**
 * @author 林子洋
 * @create 2021-08-24 9:57:19
 */
public class ThreadDebug {

    public static void run() {
        new Thread(()->{
            System.out.println("111");
        },"线程1").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("222");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程2").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("333");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程3").start();
    }

    public static void main(String[] args) {
        run();
    }

}

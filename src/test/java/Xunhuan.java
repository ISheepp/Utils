import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author linzy
 * @create 2021-03-09 21:32:28
 */
public class Xunhuan {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Thread threadB = new Thread(()->{
            System.out.println("B");
        }, "B");

        Thread threadA = new Thread(() -> {
            System.out.println("A");
            try {
                threadB.start();
                threadB.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "A");
        Thread threadC = new Thread(()->{
            System.out.println("C");
            try {
                threadA.start();
                threadA.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C");

        threadC.start();


    }

}

package sync;

/**
 * @author linzy
 * @create 2021-02-28 16:07:41
 * 多个线程互相抱着对方需要的资源，形成僵持
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        // 线程a
        Thread td1 = new Thread(new Runnable() {
            public void run() {
                DeadLockDemo.method1();
            }
        });
        // 线程b
        Thread td2 = new Thread(new Runnable() {
            public void run() {
                DeadLockDemo.method2();
            }
        });

        td1.start();
        td2.start();
    }

    public static void method1() {
        synchronized (String.class) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" .class");
            synchronized (Integer.class) {

            }

        }
    }

    public static void method2() {
        synchronized (Integer.class) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程b尝试获取String.class");
            synchronized (String.class) {

            }

        }
    }

}
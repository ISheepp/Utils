package Thread.demo1;

/**
 * @author lin
 * @create 2020-10-01 12:55
 */
public class TestThread1 extends Thread {

    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {

            System.out.println("我在看代码--"+i);
        }
    }

    public static void main(String[] args) {
        //main主线程
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程--" + i);
        }

        //调用start()方法开启线程
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();

    }
}

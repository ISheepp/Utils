package Thread.demo1;

/**
 * @author lin
 * @create 2020-10-01 13:19
 */

//创建线程方式2：实现runnable接口，重写run方法，执行线程需要丢入runnable接口实现类
public class TestThread3 implements Runnable {

    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码--" + i);
        }
    }

    public static void main(String[] args) {
        //main主线程
        TestThread3 testThread3 = new TestThread3();
        //创建线程对象，通过线程对象来开启我们的线程

        // Thread thread = new Thread(testThread3);
        // thread.start();

        new Thread(testThread3).start(); //效果与上面一样


    }

}

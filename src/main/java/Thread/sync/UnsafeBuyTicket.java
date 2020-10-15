package Thread.sync;

import lombok.SneakyThrows;

/**
 * @author lin
 * @create 2020-10-05 15:47
 */

// 不安全的买票
public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station, "苦逼的我").start();
        new Thread(station, "牛逼的你们").start();
        new Thread(station, "可恶的黄牛党").start();
    }
}

class BuyTicket implements Runnable{

    //票
    private int ticketNums = 10;
    boolean flag = true; //外部停止方式

    @SneakyThrows
    @Override
    public void run() {
        //买票
        while (flag){
            buy();
        }
    }

    // synchronized 同步方法，锁的是this
    private synchronized void buy() throws InterruptedException {

        //判断是否有票
        if (ticketNums <= 0){
            return;
        }
        //模拟延时
        Thread.sleep(1000);
        //买票
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);

    }

}
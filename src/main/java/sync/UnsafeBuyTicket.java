package sync;


/**
 * @author linzy
 * @create 2021-02-28 15:05:33
 * 多个线程操作同一个资源，线程不安全
 */
public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket s = new BuyTicket();
        new Thread(s, "1").start();
        new Thread(s, "2").start();
        new Thread(s, "3").start();
    }

}

class BuyTicket implements Runnable {

    // 票
    private int ticketNumbers = 10;
    boolean flag = true;

    @Override
    public void run() {
        // 买票
        while (flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buy();
        }
    }

    // 锁的是这个方法的调用者
    private synchronized void buy() {
        // 判断是否邮票
        if (ticketNumbers <= 0) {
            flag = false;
            return;
        }

        System.out.println((Thread.currentThread().getName() + " 拿到 " + ticketNumbers--));
    }
}

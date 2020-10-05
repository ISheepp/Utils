package Thread.state;

/**
 * @author lin
 * @create 2020-10-05 11:06
 */

//模拟网络延时
public class TestSleep implements Runnable {

    //票数
    private int ticketNums = 10;

    public void run() {

        //买票，死循环
        while (true) {
            if (ticketNums<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums--+ "张票");
        }
    }

    public static void main(String[] args) {
        TestSleep ticket = new TestSleep();

        new Thread(ticket, "晓明").start();
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛").start();

    }

}

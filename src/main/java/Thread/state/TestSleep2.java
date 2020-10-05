package Thread.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lin
 * @create 2020-10-05 11:14
 */

//模拟倒计时
//sleep不会释放锁
public class TestSleep2 {

    public static void main(String[] args) throws InterruptedException {

        // tenDown();


        //打印当前时间
        Date date = new Date(System.currentTimeMillis());

        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            date = new Date(System.currentTimeMillis()); //更新当前时间
        }
    }

    public static void tenDown() throws InterruptedException {

        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num <= 0){
                break;
            }
        }

    }

}

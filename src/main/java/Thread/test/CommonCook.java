package Thread.test;

/**
 * 只能已单线程实现
 * 不通过join进行阻塞的话则会导致没有厨具
 * @author linzy
 * @create 2020-12-21 14:12:09
 */
public class CommonCook {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        // 第一步 网购厨具
        OnlineShopping thread = new OnlineShopping();
        thread.start();

        //通过join线程来阻断主线程，以先保证厨具送到才继续往下走
        thread.join();

        // 第二步 去超市购买食材
        Thread.sleep(2000);  // 模拟购买食材时间
        Shicai shicai = new Shicai();
        System.out.println("第二步：食材到位");


        // 第三步 用厨具烹饪食材
        System.out.println("第三步：开始展现厨艺");
        cook(thread.chuju, shicai);

        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }

    // 网购厨具线程的线程类
    static class OnlineShopping extends Thread {

        private Chuju chuju;

        @Override
        public void run() {
            System.out.println("第一步：下单");
            System.out.println("第一步：等待送货");
            try {
                Thread.sleep(5000);  // 模拟快递小哥送货时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第一步：快递送到");
            chuju = new Chuju(); //拿到厨具了
        }

    }

    //  用厨具烹饪食材的线程  做饭肯定得厨具、食材都有了才能开始  所以传进去
    static void cook(Chuju chuju, Shicai shicai) {}

    // 厨具类
    static class Chuju {}

    // 食材类
    static class Shicai {}
}
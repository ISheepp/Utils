package sync;

/**
 * @author linzy
 * @create 2021-02-28 17:13:30
 * 测试管程法（利用缓冲区解决）生产者消费者模型
 */
public class TestPC {

    public static void main(String[] args) {

        SyncCache cache = new SyncCache();
        new Producer(cache).start();
        new Consumer(cache).start();
    }

}

// 生产者
class Producer extends Thread {
    SyncCache cache;

    public Producer(SyncCache cache) {
        this.cache = cache;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            cache.push(new Chicken(i));
            System.out.println("生产了" + i + "只鸡");
        }
    }
}

// 消费者
class Consumer extends Thread {
    SyncCache cache;

    public Consumer(SyncCache cache) {
        this.cache = cache;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了-->" + cache.pop().id + "只鸡");
        }
    }
}

// 产品
class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

// 缓冲区
class SyncCache {
    // 需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    // 容器计数器
    int count = 0;

    // 生产者放入产品
    public synchronized void push(Chicken chicken) {
        // 如果容器满了就需要等待消费者消费
        if (count == 10) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = chicken;
        count++;
        this.notifyAll();
    }

    public synchronized Chicken pop() {
        // 判断能否消费
        if (count == 0) {
            // 等待生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果可以消费
        count--;
        this.notifyAll();

        // 通知生产者生产
        return chickens[count];
    }

}

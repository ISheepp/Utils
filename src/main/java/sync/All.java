package sync;

import java.util.concurrent.*;

/**
 * @author linzy
 * @create 2021-02-28 19:12:12
 */
public class All {

    public static void main(String[] args) {
        callAble callAble = new callAble();
        FutureTask<Integer> task = new FutureTask<>(callAble);
        new Thread(task).start();
        try {
            Integer i = task.get();
            System.out.println(i);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 或者
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<Integer> result = pool.submit(callAble);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class callAble implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // System.out.println("2");
        return 100;
    }
}

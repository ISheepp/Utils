package juc.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author linzy
 * @date 2021-03-04 20:58:41
 * 求和计算
 * 如何使用forkjoin
 * 1、forkjoinPool通过它来执行
 * 2、计算任务 forkjoinPool.execute(ForkJoinTask task)
 *
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    // 修改类的属性的时候，serialVersionUID会改变，显式定义防止反序列化失败
    private static final long serialVersionUID = -450720490419704593L;
    private Long start;

    private Long end;

    // 临界值
    private Long temp = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }


    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        long reduce = LongStream.rangeClosed(0, 10000000L).reduce(0, Long::sum);
        System.out.println(reduce);
        System.out.println(System.currentTimeMillis());
    }

    public void test() {

    }

    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork(); // 拆分任务，把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1, end);
            task2.fork();

        }
        return null;
    }
}

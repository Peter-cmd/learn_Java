package calculate;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest {
    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool();

        Instant start = Instant.now();

        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 10000000000L);
        Long sum = pool.invoke(task);

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis() + "毫秒");
        System.out.println(sum);

        test(0L, 10000000000L);


    }


    public static void test(long start, long end) {
        long sum = 0;
        Instant s = Instant.now();
        for (long i = start; i <= end; i++) {
            sum += i;
        }
        Instant e = Instant.now();
        System.out.println(Duration.between(s, e).toMillis() + "毫秒");
        System.out.println(sum);
    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = -238939894594589L;

    private long start;
    private long end;

    private static final long THRESHOLD = 10000000L;

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        // 若拆分达到阈值, 进行计算.
        if (length <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else {
            long mid = start + (end - start) / 2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, mid);
            left.fork();  // 将线程进行拆分, 并压入线程队列
            ForkJoinSumCalculate right = new ForkJoinSumCalculate(mid + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }
}

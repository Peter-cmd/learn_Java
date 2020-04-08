package demo003;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;

public class Test {
    ExecutorService pool1 = Executors.newSingleThreadExecutor();
    ExecutorService pool2 = Executors.newFixedThreadPool(1);  //此时 pool2 与 pool1 等价
    ExecutorService pool3 = Executors.newCachedThreadPool();
    ExecutorService pool4 = Executors.newScheduledThreadPool(5);


    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            2,
            5,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return null;
                }
            },
            new ThreadPoolExecutor.CallerRunsPolicy()
    );
}

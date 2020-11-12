package demo1111;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    ExecutorService pool1 = Executors.newSingleThreadExecutor();
    ExecutorService pool2 = Executors.newFixedThreadPool(1);
    ExecutorService pool3 = Executors.newCachedThreadPool();
    ExecutorService pool4 = Executors.newScheduledThreadPool(2);


}

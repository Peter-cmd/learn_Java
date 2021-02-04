package mutex;

import java.util.concurrent.CountDownLatch;

public class Main {
    private static CountDownLatch latch = new CountDownLatch(3);
    private static MyMutex myMutex = new MyMutex();
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        // 创建3个线程, 分别实现对count进行10000000次加1操作
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 获取自定义同步锁资源
                    myMutex.lock();
                    for (int i = 0; i < 10000000; i++) {
                        count++;
                    }
                    // 释放自定义同步锁资源
                    myMutex.unlock();
                    // 计数闩中的计数器减1, 减到0释放计数闩
                    latch.countDown();
                }
            }).start();
        }
        // 等待计数闩释放
        latch.await();
        System.out.println(count);
    }
}

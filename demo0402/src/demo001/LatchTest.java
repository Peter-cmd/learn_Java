package demo001;

import java.util.concurrent.CountDownLatch;

public class LatchTest {
    private static int SUM = 10;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(SUM);
        for (int i = 0; i < SUM; i++){
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
                    SUM--;
                    latch.countDown();
                }
            }).start();
        }

        latch.await();
        System.out.println("当前sum = " + SUM);
    }
}

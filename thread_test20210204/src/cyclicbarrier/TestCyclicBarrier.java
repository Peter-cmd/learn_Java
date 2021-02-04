package cyclicbarrier;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

    private static void meeting() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            // 三个人员到齐之后执行的代码
            @Override
            public void run() {
                System.out.println("所有人员业已到达, 开会!");
            }
        });

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        // 模拟第 i 个人到达的时间
                        Thread.sleep((long)(Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第" + Thread.currentThread().getName() + "个人已到达会议室!");

                    try {
                        // 等待其他人员到达
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "开始开会!");
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        meeting();
    }


}

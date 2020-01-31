package test0131.demo0003;

public class ThreadAdvantage {

    private static final long NUM = 10_0000_0000L;
    private static final int COUNT2 = Runtime.getRuntime().availableProcessors();
    private static final int COUNT = 2;

    public static void serial() {
        for (int i = 0; i < COUNT; i++) {
            i++;
        }
    }

    public static void parallel() {
        for (int i = 0; i < COUNT; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    serial();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        serial();
        long end1 = System.currentTimeMillis();
        System.out.println("串行: " + (end1 - start1) + "毫秒");

        long start2 = System.currentTimeMillis();
        parallel();
        while (Thread.activeCount() > 1)
            Thread.yield();
        long end2 = System.currentTimeMillis();
        System.out.println("并行: " + (end2 - start2) + "毫秒");
    }
}

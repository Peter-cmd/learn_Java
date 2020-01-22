package test0116.demo0004;

public class InterruptedDemo02 {
    private static class MyRunnable implements Runnable{
        @Override
        public void run() {
            while (!Thread.interrupted()){
//            while (!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName()
                        + ": 别打扰我!我忙着转账呢.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName()
                            + ": 有内鬼,终止交易!");
                    break;
                }

            }
            System.out.println(Thread.currentThread().getName()
                    + ": 啊!险些酿成大祸!");
        }
    }
    public static void main(String[] args) throws InterruptedException{
        MyRunnable target = new  MyRunnable();
        Thread thread = new Thread(target, "李四");
        System.out.println(Thread.currentThread().getName()
                + ": 让李四开始转账!");
        thread.start();
        Thread.sleep(10 * 1000);
        System.out.println(Thread.currentThread().getName()
                + ": 老板来电话了,得赶紧通知李四对方是个骗子.");
        thread.interrupt();

    }
}

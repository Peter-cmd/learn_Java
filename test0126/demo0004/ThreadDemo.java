package test0126.demo0004;

public class ThreadDemo {
    public static class Counter{
        private long n = 0;

        public synchronized void increment(){
            n++;
        }

        public synchronized void decrement(){
            n--;
        }

        public synchronized long value(){
        return n;
        }
    }
    private static Counter c = new Counter();
    private static final int COUNT = 1000_0000;
    public static void main(String[] args) throws InterruptedException{
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0; i < COUNT; i++) {
                    c.increment();
                }
            }
        }, "李四");
        t.start();
        for (int i = 0; i < COUNT; i++){
            c.decrement();
        }
        t.join();
        System.out.println(c.value());
    }
}

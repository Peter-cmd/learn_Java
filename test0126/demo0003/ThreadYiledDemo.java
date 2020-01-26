package test0126.demo0003;

public class ThreadYiledDemo {
    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    System.out.println(Thread.currentThread().getName()
                            + "正跑着呢!");
                    //Thread.yield();
                }
            }
        }, "李四");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println(Thread.currentThread().getName()
                            + "正跑着呢!");
                }
            }
        }, "王五");

        t1.start();
        t2.start();
    }
}

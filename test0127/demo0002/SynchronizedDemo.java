package test0127.demo0002;

class MyThread implements Runnable{
    private int ticket = 10;  //一共10张票
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            synchronized(this){
                if (ticket > 0){  //若还有票
                    try {
                        Thread.sleep(20);  //休眠20秒
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ",现在还有"
                            + --ticket + "张票.");
                }
            }
        }
    }
}

public class SynchronizedDemo {
    public static void main(String[] args){
        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt, "黄牛A");
        Thread t2 = new Thread(mt, "黄牛B");
        Thread t3 = new Thread(mt, "黄牛C");
        t1.start();
        t2.start();
        t3.start();
    }

}

public class NotifyTest {
    //主函数
    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable(){  //实例化一个线程
            @Override
            public void run() {
                try {
                    synchronized(NotifyTest.class){
                        NotifyTest.class.wait();  //释放当前对象锁
                        System.out.println("t1 等待结束.");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();  //

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                    synchronized(NotifyTest.class){
                        NotifyTest.class.notify();
                        System.out.println("t2 等待结束.");
                    }
                }
        });
        t2.start();

        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run() {
                    synchronized(NotifyTest.class){
                        NotifyTest.class.notify();
                        System.out.println("t3 等待结束.");
                    }
                }
        });
        t3.start();
    }
}


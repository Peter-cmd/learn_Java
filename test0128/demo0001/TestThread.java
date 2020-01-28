package test0128.demo0001;


class MyThread implements Runnable{
    private boolean flag;
    private Object object;

    public MyThread(boolean flag, Object object){
        super();
        this.flag = flag;
        this.object = object;
    }

    public void waitThread(){
        synchronized(object){
            try{
                while (true){
                    System.out.println("wait()方法开始..."
                            + Thread.currentThread().getName());
                    object.wait();
                    System.out.println("wait()方法结束..."
                            + Thread.currentThread().getName());
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void notifyThread(){
        synchronized(object){
            try {
                System.out.println("notify()方法开始..."
                        + Thread.currentThread().getName());
                object.notify();
                System.out.println("notify()方法结束..."
                        + Thread.currentThread().getName());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        if(flag){
            this.waitThread();
        }else{
            this.notifyThread();
        }
    }
}

public class TestThread {
    public static void main(String[] args) throws InterruptedException{
        Object object = new Object();
        MyThread waitThread = new MyThread(true, object);
        MyThread notifyThread = new MyThread(false, object);
        Thread thread1 = new Thread(waitThread, "wait线程");
        Thread thread2 = new Thread(notifyThread, "notify线程");
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        System.out.println("main方法结束.");

    }
}

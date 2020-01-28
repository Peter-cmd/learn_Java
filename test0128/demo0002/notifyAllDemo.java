package test0128.demo0002;

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
                while(true) {
                    System.out.println("wait()方法开始..."
                            + Thread.currentThread().getName());
                    object.wait();
                    System.out.println("wait()方法结束..."
                            + Thread.currentThread().getName());
                    return;
                }
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void notifyAllThread(){
        synchronized(object){
            try{
                System.out.println("notifyAll()方法开始..."
                        + Thread.currentThread().getName());
                object.notifyAll();
                System.out.println("notifyAll()方法结束..."
                        + Thread.currentThread().getName());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        if (flag){
            this.waitThread();
        } else{
            this.notifyAllThread();
        }
    }
}

public class notifyAllDemo {
    public static void main(String[] args) throws InterruptedException{
        Object object = new Object();
        MyThread waitThread1 = new MyThread(true, object);
        MyThread waitThread2 = new MyThread(true, object);
        MyThread waitTHread3 = new MyThread(true, object);
        MyThread notifyAllThread = new MyThread(false, object);
        Thread thread1 = new Thread(waitThread1, "wait线程A");
        Thread thread2 = new Thread(waitThread1, "wait线程B");
        Thread thread3 = new Thread(waitThread1, "wait线程C");
        Thread thread4 = new Thread(notifyAllThread, "notifyAll线程");
        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(1000);
        thread4.start();
        System.out.println("main方法结束!");

    }
}

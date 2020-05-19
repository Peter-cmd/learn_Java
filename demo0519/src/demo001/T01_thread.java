package demo001;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class T01_thread {
//    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    private Semaphore semaphore = new Semaphore(2);
//
//    private void doSomething(){
//
//        try {
//            semaphore.acquire();
//            System.out.println(Thread.currentThread().getName() + ":doSomething start" + getFormatTimeStr());
//            Thread.sleep(2000);
//            System.out.println(Thread.currentThread().getName() + ":doSomething end " + getFormatTimeStr());
//            semaphore.release();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static String getFormatTimeStr() {
//        return sdf.format(System.currentTimeMillis());
//    }

    public static void main(String[] args){
//        T01_thread t = new T01_thread();
        Semaphore semaphore = new Semaphore(1);

        for (int i = 0; i < 10; i++){
            new MyThread(semaphore).start();
        }
    }
}
class MyThread extends Thread{
    Semaphore semaphore = null;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public MyThread(Semaphore semaphore){
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + ":doSomething start" + getFormatTimeStr());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + ":doSomething end " + getFormatTimeStr());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String getFormatTimeStr() {
        return sdf.format(System.currentTimeMillis());
    }
}

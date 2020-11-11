package reentrant.lock.test.t02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread implements Runnable {
    private static Lock lock = new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i < 3; i++){
            lock.lock();
            try {
                if (i == 0){
                    System.out.println(Thread.currentThread().getName() + " " + "A");
                }else if (i == 1){
                    System.out.println(Thread.currentThread().getName() + " " + "B");
                }else{
                    System.out.println(Thread.currentThread().getName() + " " + "C");
                }

            } finally {
                lock.unlock();
            }

        }
    }


    public static void main(String[] args){
        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt, "Thread-1");
        Thread t2 = new Thread(mt, "Thread-2");
        t1.start();
        t2.start();
    }
}

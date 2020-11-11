package reentrant.lock.test.t03;


import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();

    public static void main(String[] args){
        Thread tA = new Thread(new PrintA(lock, condition2), "Thread-A");
        Thread tB = new Thread(new PrintB(lock, condition2, condition3), "Thread-B");
        Thread tC = new Thread(new PrintC(lock, condition3), "Thread-C");
        tC.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tB.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tA.start();
    }
}


class PrintA implements Runnable{
    private Lock lock = null;
    private Condition condition = null;
    public PrintA(Lock lock, Condition condition){
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("A");
        condition.signal();
        lock.unlock();

    }
}

class PrintB implements Runnable{
    private Lock lock = null;
    private Condition conditionB = null;
    private Condition conditionC = null;

    public PrintB(Lock lock, Condition conditionB, Condition conditionC){
        this.lock = lock;
        this.conditionB = conditionB;
        this.conditionC = conditionC;
    }
    @Override
    public void run() {
        lock.lock();
        try {
            conditionB.await();
            System.out.println("B");
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();

    }
}

class PrintC implements Runnable{
    private Lock lock = null;
    private Condition conditionC = null;
    public PrintC(Lock lock, Condition conditionC){
        this.lock = lock;
        this.conditionC = conditionC;
    }
    @Override
    public void run() {
        lock.lock();
        try {
            conditionC.await();
            System.out.println("C");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}
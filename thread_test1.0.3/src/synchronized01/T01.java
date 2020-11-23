package synchronized01;

public class T01 {
    public static void main(String[] args) {
        A a = new A();
        new Thread(new Runnable() {
            @Override
            public void run() {
                a.sayA();
            }
        }, "Thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a.sayA();
            }
        }, "Thread2").start();
    }
}

class A{
    public synchronized void sayA(){
        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
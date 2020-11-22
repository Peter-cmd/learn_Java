package synchronized03;

public class T03 {
    public static void main(String[] args){
        A a = new A();
//        new Thread(new A(), "Thread1").start();
//        new Thread(new A(), "Thread2").start();
        new Thread(a, "Thread1").start();
        new Thread(a, "Thread2").start();
    }
}

class A implements Runnable{
    @Override
    public void run() {
        synchronized (this){
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
}
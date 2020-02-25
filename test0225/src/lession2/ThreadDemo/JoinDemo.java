package lession2.ThreadDemo;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("A");
            }
        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("B");
            }
        });

        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("C");
            }
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
    }
}

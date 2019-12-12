package lesson1;

public class CreatRunnableTest {
    public static void main(String[] args){
        Thread t = new Thread(new MyRunnabl(),"MyThread");
        t.start();
        System.out.println(Thread.currentThread().getName());
    }
}

class MyRunnabl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

    }
}
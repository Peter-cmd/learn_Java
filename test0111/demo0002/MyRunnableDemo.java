package test0111.demo0002;

public class MyRunnableDemo {
    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "这里是线程运行的代码.");
        }
    }

    public static void main(String[] args){
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        thread1.start();
        thread2.start();
    }
}
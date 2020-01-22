package test0111.demo0004;

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "这里是线程运行的代码.");
    }
}
public class MyThread03 {

    public static void main(String[] args){
        Thread t1 = new Thread();
        Thread t2 = new Thread(new MyRunnable());
        Thread t3 = new Thread("晴明");
        Thread t4 = new Thread(new MyRunnable(),"小白");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }


}

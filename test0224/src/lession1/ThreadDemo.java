package lession1;

public class ThreadDemo {
    public static void main(String[] args){
        MyThread t = new MyThread("我的线程");
        t.run();
        while (true) {}
    }
}

class MyThread extends Thread{

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        while (true){}
    }
}
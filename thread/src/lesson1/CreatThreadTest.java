package lesson1;

public class CreatThreadTest {

    public static void main(String[] args){
        MyThread thread = new MyThread("my thread");

        thread.run();  //在run中循环,一直没有退出

        thread.start();  //启动的子线程和主线程同时执行
        while(true){}
    }
}

class MyThread extends Thread {

    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
       // System.out.println(Thread.currentThread().getName());
        while(true){}
    }
}
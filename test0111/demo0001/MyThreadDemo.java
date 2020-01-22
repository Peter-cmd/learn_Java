package test0111.demo0001;

public class MyThreadDemo {
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("这里是线程运行的代码.");
        }
    }

    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

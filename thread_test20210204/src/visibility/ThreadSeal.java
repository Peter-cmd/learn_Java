package visibility;

import java.util.concurrent.TimeUnit;

public class ThreadSeal {
    public volatile int a = 1;

    class MyThread implements Runnable{

        public MyThread(int b) {
            a = b;
        }

        @Override
        public void run() {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(a);
        }
    }

    public static void main(String[] args){
        ThreadSeal ts = new ThreadSeal();
        for (int i = 1; i <= 10; i++) {
            new Thread(ts.new MyThread(i)).start();
        }

    }
}



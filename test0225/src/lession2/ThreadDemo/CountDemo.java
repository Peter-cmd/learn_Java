package lession2.ThreadDemo;

public class CountDemo {
    static int COUNT = 0;

    public static void main(String[] args){
        Runnable r = new Runnable(){
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    synchronized (this){
                        COUNT++;
                    }
                }
            }
        };
            for (int i = 0; i < 20; i++) {
                new Thread(r).start();
            }

        while (Thread.activeCount() > 2){
            Thread.yield();  //线程让出 CPU, 从运行态转化为就绪态
        }
        System.out.println(COUNT);
    }
}

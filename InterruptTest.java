package test1215;

public class InterruptTest {
    private static int COUNT;

    public static void main(String[] args){
//        Thread t = new Thread();
//        boolean interrupted = Thread.interrupted();
//        t.interrupt();
//        t.interrupted();

        UnsafeTest();
    }
    public static void ignoreInterrupt(){

    }

    public static void UnsafeTest(){
        for (int i = 0 ; i < 20; i++){
            new Thread(new Runnable(){
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++){
                        COUNT++;
                    }
                }
            }).start();
        }
        while(Thread.activeCount() > 1){
            Thread.yield();  //线程让步,当前进程从运行态转换为就绪态
            System.out.println(COUNT);
        }

    }
}

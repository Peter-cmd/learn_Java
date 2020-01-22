package test0116.demo0002;

public class JoinTest {
    public static void main(String[] args) throws
            InterruptedException {
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    Thread.sleep(100);
                }
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
            }
        });
        t.start();
        t.join(300);
        System.out.println("main");
    }
}

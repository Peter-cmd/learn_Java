package test0126.demo0002;

public class ThreadStateTransfer {
    public static void main(String[] args){
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){

                }
            }
        }, "李四");
        System.out.println(t.getName() + " : " + t.getState());
        t.start();
        while (t.isAlive()) {
            System.out.println(t.getName() + " : " + t.getState());
        }
        System.out.println(t.getName() + " : " + t.getState());

    }
}

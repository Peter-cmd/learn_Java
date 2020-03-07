package demo0001;

public class DeadLock {
    public static void main(String[] args){
        String str1 = "Hello Word";
        String str2 = "Hell0 Word";

        new Thread(new Runnable(){

            @Override
            public void run() {
                synchronized(str1){
                    while(true) {
                        System.out.println("first");
                    }
                }
            }
        }).start();

        new Thread(new Runnable(){

            @Override
            public void run() {

                while(true) {
                    synchronized (str2) {
                        System.out.println("second");
                    }
                }
            }
        }).start();

    }


}

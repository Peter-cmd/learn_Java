package synchronized02;

public class T02 {
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                A.sayA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                A.sayA();
            }
        }).start();
    }

}


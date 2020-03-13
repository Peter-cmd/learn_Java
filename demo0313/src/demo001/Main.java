package demo001;

public class Main {
    public static void main(String[] args){
        Thread t = new Thread(){
            @Override
            public void run() {
                pong();
            }
        };

        t.run();
        System.out.println("ping");
    }

    static void pong(){
        System.out.println("pong");
    }
}

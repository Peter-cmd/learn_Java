package lession2;

public class ThreadDemo02 {
    public static void main(String[] args) {
        try {

            InterruptedExit();
            NotInterrupted();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void NotInterrupted() throws InterruptedException{
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                    try {
                        while (!Thread.currentThread().isInterrupted()) {
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(1000);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });

        t.start();
        Thread.sleep(3000);
        t.interrupt();
    }

    public static void InterruptedExit() throws InterruptedException{
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    try {

                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();
        Thread.sleep(3000);
        t.interrupt();
    }
}

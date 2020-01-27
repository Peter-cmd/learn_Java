package test0127.demo0001;

public class InstructReorderDemo {
    private static class Counter{
        private int n1 = 0;
        private int n2 = 0;
        private int n3 = 0;
        private int n4 = 0;
        private int n5 = 0;
        private int n6 = 0;
        private int n7 = 0;
        private int n8 = 0;
        private int n9 = 0;
        private int n10 = 0;

        public void write(){
            n1 = 1;
            n2 = 2;
            n3 = 3;
            n4 = 4;
            n5 = 5;
            n6 = 6;
            n7 = 7;
            n8 = 8;
            n9 = 9;
            n10 = 10;
        }

        public void read(){
            System.out.println("n1 = " + n1);
            System.out.println("n2 = " + n2);
            System.out.println("n3 = " + n3);
            System.out.println("n4 = " + n4);
            System.out.println("n5 = " + n5);
            System.out.println("n6 = " + n6);
            System.out.println("n7 = " + n7);
            System.out.println("n8 = " + n8);
            System.out.println("n9 = " + n9);
            System.out.println("n10 = " + n10);
        }

    }

    static Counter c = new Counter();
    public static void main(String[] args){

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                c.write();
            }
        }, "写");

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                c.read();
            }
        }, "读");

        t1.start();
        t2.start();
    }
}

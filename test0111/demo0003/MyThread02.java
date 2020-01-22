package test0111.demo0003;

public class MyThread02 {
    public static void main(String[] args){
        //使用匿名类创建 Thread 子类对象
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("使用匿名类创建 Thread 子类对象.");
            }
        };
        t1.start();

        //使用匿名类创建 Runnable 子类对象
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("使用匿名类创建 Runnable 子类对象.");
            }
        });
        t2.start();
    }
}

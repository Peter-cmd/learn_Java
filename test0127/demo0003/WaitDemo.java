package test0127.demo0003;

public class WaitDemo {
    public static void main(String[] args) throws InterruptedException{
        Object object = new Object();
        synchronized(object){
            System.out.println("等待中……");
            object.wait();
            System.out.println("等待结束.");
        }
        System.out.println("main方法结束");
    }
}

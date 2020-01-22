package test0116.demo0003;

public class SleepDemo {
    public static void main(String[] args) throws InterruptedException{
        System.out.println(System.currentTimeMillis());
        Thread.sleep(3000);
        System.out.println(System.currentTimeMillis());
    }
}

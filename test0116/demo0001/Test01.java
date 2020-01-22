package test0116.demo0001;

public class Test01 {
    public static void main(String[] args){
        //获取当前线程的引用
        Thread thread = Thread.currentThread();
        System.out.println("当前进程名为:" + thread.getName());
    }
}

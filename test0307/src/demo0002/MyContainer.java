package demo0002;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
public class MyContainer{
    volatile List list = new ArrayList();

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args){
        MyContainer myContainer = new MyContainer();
        CountDownLatch latch = new CountDownLatch(1);  //实例化一个门锁
        new Thread(() -> {
            System.out.println("t2启动");
            if (myContainer.size() != 5){
               try {
                   latch.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
            }
            System.out.println("t2结束");
            }, "t2").start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("t1启动");
            for (int i = 0; i < 10; i++){
                myContainer.add(new Object());
                System.out.println("add" + i);
                if (myContainer.size() == 5){
                    latch.countDown();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1结束");
        },"t1").start();


    }


}

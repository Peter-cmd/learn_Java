package demo0003;

import demo0002.MyContainer;

import java.util.ArrayList;
import java.util.List;

public class MyCotainer {

    volatile List list = new ArrayList();

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return list.size();
    }


    public static void main(String[] args) {
        final MyContainer myContainer = new MyContainer();
        //对象锁
        Object lock = new Object();

        //创建线程2
        new Thread(() -> {
            System.out.println("t2启动");
            synchronized (lock){
                if (myContainer.size() != 5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2结束");
                lock.notify();
            }

        }, "t2").start();

        //程序休眠1秒
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //创建线程1
        new Thread(() -> {
            System.out.println("t1启动");
            //获取对象锁
            synchronized (lock){
                //循环插入10个对象
                for (int i = 0; i < 10; i++){
                    myContainer.add(new Object());  //插入对象
                    System.out.println("add" + i);  //打印插入对象的插入位置
                    //若插入了第5个对象,通知t2,t1释放并等待对象锁
                    if (myContainer.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //线程休眠1秒
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t1结束");
            }
        },"t1").start();
    }
}

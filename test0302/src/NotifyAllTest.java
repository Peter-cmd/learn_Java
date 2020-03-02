public class NotifyAllTest {
    public static int COUNT;
    public static void main(String[] args){
        
        for (int i = 0; i < 1; i++){  //生产者的数量
            new Thread(new Producers()).start();

        }
        for (int j = 0; j < 1; j++){  //消费者的数量
            new Thread(new Consumers()).start();
        }
    }

    private static class Producers implements Runnable{
        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {  //一个生产者生产面包的次数
                    synchronized (NotifyAllTest.class) {  //生产者竞争类对象加锁
                        while (COUNT + 3 > 100) {  //代售的面包数量不能超过100
                            NotifyAllTest.class.wait();  //当前线程等待
                        }
                        COUNT += 3;  //生产3个面包
                        NotifyAllTest.class.notifyAll();  //通知所有等待的线程
                        //打印面包生产情况
                        System.out.println(Thread.currentThread().getName() + "生产了面包,还剩" + COUNT + "个");
                        Thread.sleep(1000);  //生产者休息1秒
                    }
                    Thread.sleep(1000);  //生产者过1秒再竞争类对象锁
                }
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
    }

    private static class Consumers implements Runnable{
        @Override
        public void run() {
            try {
                while (true) {  //消费者可以重复购买面包
                    synchronized (NotifyAllTest.class) {  //消费者竞争类对象锁
                        while (COUNT == 0) {  //当面包的数量为0
                            NotifyAllTest.class.wait();  //消费者进行等待
                        }
                        COUNT -= 1;  //消费者购买面包
                        NotifyAllTest.class.notifyAll();  //通知所有等待中的线程
                        //打印面包销售情况
                        System.out.println(Thread.currentThread().getName() + "购买了面包,还剩" + COUNT + "个");
                        Thread.sleep(1000);  //消费者休息1秒
                    }
                    Thread.sleep(1000);  //消费者过1秒再竞争锁
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}




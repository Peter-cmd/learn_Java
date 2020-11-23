package synchronized05;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PublicBoxQueue {
    public static void main(String[] args){
        BlockingQueue publicBoxQueue = new LinkedBlockingQueue(5);

        Thread pro = new Thread(new ProducerQueue(publicBoxQueue), "生产者");
        Thread con = new Thread(new ConsumerQueue(publicBoxQueue), "消费者");

        pro.start();
        con.start();


    }

}

class ProducerQueue implements Runnable{
    private final BlockingQueue proQueue;

    public ProducerQueue(BlockingQueue proQueue){
        this.proQueue = proQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "生产的苹果编号为" + i);
            try {
                proQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerQueue implements Runnable{
    private final BlockingQueue conQueue;

    public ConsumerQueue(BlockingQueue conQueue){
        this.conQueue = conQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                System.out.println(Thread.currentThread().getName() + "消费的苹果编号为" + conQueue.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


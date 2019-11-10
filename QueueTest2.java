package Test;

public class QueueTest2 {
    private int[] data = new int[100];
    private int head = 0;  //队首元素下标
    private int tail = 0;  //队尾元素下标
    private int size = 0;  //队列大小

    //队尾插入元素
    public boolean offer(int val){
        //若队列已满
        if (size == data.length){
            return false;
        }

        data[tail] = val;  //插入数据
        tail++;
        //处理tail走到队尾,但队不满的情况
        if (tail == data.length){
            tail = 0;
        }
        size++;  //实际已存数据加1
        return true;
    }

    //元素出队方法
    public Integer poll(){
        //处理队列为空的情况
        if (size == 0){
            return null;
        }

        //记录队首元素
        Integer ret = data[head];
        head++;
        //若head走到队尾,但队不满的情况
        if (head == data.length){
            head = 0;
        }
        size--;  //实际已存数据减1
        return ret;
    }

    //获取队首元素
    public Integer peek(){
        //处理队列为空的情况
        if (size == 0){
            return null;
        }
        //记录队首元素
        Integer ret = data[head];
        return ret;
    }

    //判定队是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //获取队列的大小
    public int size(){
        return size;
    }

    public static void main(String[] agrs) {
        QueueTest2 queue = new QueueTest2();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        while (!queue.isEmpty()){
            System.out.println("队首元素:");
            Integer ret = queue.peek();
            System.out.println(ret);
            System.out.println("出队元素:");
            System.out.println(queue.poll());
        }
    }
}

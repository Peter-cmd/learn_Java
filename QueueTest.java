package Test;

class Node{
    int var;
    Node next;

    Node(int var, Node next){
       this.var = var;
       this.next = next;
   }

    Node(int var){
       this(var,null);
   }
}

public class QueueTest {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    //元素进队
    public void offer(int var){
        Node node = new Node(var);
        //处理队为空的情况
        if (tail == null){
            head = node;
        }else{
            tail.next = node;
        }
        tail = node;
        size++;
    }

    //元素出队
    public int poll(){
        if (size == 0){
            throw new RuntimeException("队列为空");
        }

        Node oldHead = head;
        head = head.next;
        //若head指向为空
        if (head == null){
            tail = null;
        }
        size--;
        return oldHead.var;
    }

    //返回队首元素的值
    public int peek(){
        if (size == 0){
            throw new RuntimeException("队列为空");
        }
        return head.var;
    }

    //判定队是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //获取队的大小
    public int size(){
        return size;
    }

    public static void main(String[] args){
        QueueTest queue = new QueueTest();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        while (!queue.isEmpty()){
            System.out.println("队首元素:");
            int ret = queue.peek();
            System.out.println(ret);
            System.out.println("出队元素:");
            System.out.println(queue.poll());
        }
    }
}

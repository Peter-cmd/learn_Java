package Test;
import java.util.LinkedList;
import java.util.Queue;

public class myStack {

    private Queue<Integer> queue1 = new LinkedList<>();  //用于存放数据
    private Queue<Integer> queue2 = new LinkedList<>();  //用于辅助获取数据(始终为空)

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {

        //若队列为空
        if (queue1.isEmpty()){
            return null;
        }

        //将队列queue1中除最后一个元素外全部出队并存入queue2
        while(queue1.size() > 1) {
            int ret = queue1.remove();
            queue2.add(ret);
        }

        //获取队列尾部元素,即栈的栈顶元素
        int cur = queue1.remove();
        //交换队列queue1和queue2
        swap();
        return cur;

    }

    //交换队列内容
    private void swap(){
        Queue<Integer> queue3 = queue1;
        queue1 = queue2;
        queue2 = queue3;
    }

    /** Get the top element. */
    public Integer top() {
        //处理队列为空的情况
        if (queue1.isEmpty()){
            return null;
        }

        //将队列queue1中除最后一个元素外的元素出队,并存入queue2
        while(queue1.size() > 1){
            int ret = queue1.remove();
            queue2.add(ret);
        }

        //将队列中最后一个元素,即栈顶元素返回
        int cur = queue1.remove();
        queue2.add(cur);
        swap();
        return cur;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

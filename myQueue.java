package Test;
import java.util.Stack;
public class myQueue {

    private Stack<Integer> stack1 = new Stack<>();  //将数据存入stack1中
    private Stack<Integer> stack2 = new Stack<>();  //辅助输出获取数据

    /** Push element x to the back of queue. */
    public void push(int x) {
        //若stack2不为空
        while(!stack2.isEmpty()){
            int ret = stack2.pop();
            stack1.push(ret);
        }
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public Integer pop() {
        //处理对为空队情况
        if (stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }

        //若stack2不为空
        if (!stack2.isEmpty()){
            return stack2.pop();
        }

        //将stack1中的数据导入stack2
        while(!stack1.isEmpty()){
            int ret = stack1.pop();
            stack2.push(ret);
        }

        //队首元素元素出队,并返回
        return stack2.pop();
    }

    /** Get the front element. */
    public Integer peek() {
        //处理队为空的情况
        if (stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }

        //若stack2不为空
        if (!stack2.isEmpty()){
            return stack2.peek();
        }

        //若stack1不为空
        while (!stack1.isEmpty()){
            int ret = stack1.pop();
            stack2.push(ret);
        }

        //返回队首元素
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

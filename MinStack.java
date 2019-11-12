package Test;
import java.util.Stack;
public class MinStack {
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();
    public void push(int x) {
        stackA.push(x);
        //若stackB为空
        if (stackB.isEmpty()){
            stackB.push(x);
        }else{
            //当前最小数据与新插入数据进行比较
            int min = stackB.peek();
            if (min > x){
                min = x;
            }
            stackB.push(min);
        }
    }

    //出栈
    public void pop() {
        stackA.pop();
        stackB.pop();
    }

    //获取栈顶元素
    public int top() {
        return stackA.peek();
    }

    //获取栈中最小的元素
    public int getMin() {
        return stackB.peek();
    }
}

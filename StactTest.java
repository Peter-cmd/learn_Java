package Test;

public class StactTest {
    private int[] array = new int[100];
    private int size = 0;

    //push方法
    public void push(int var){
        array[size++] = var;
    }

    //pop方法
    public int pop(){
        return array[--size];
    }

    //获取栈顶元素
    public int peek(){
        return array[size - 1];
    }

    //判定栈是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //获取栈的大小
    public int size(){
        return size;
    }

    public static void main(String[] args){
        StactTest stact = new StactTest();
        stact.push(1);
        stact.push(2);
        stact.push(3);
        stact.push(4);
        while(!stact.isEmpty()){
            System.out.println("栈顶元素:");
            int ret = stact.peek();
            System.out.println(ret);
            System.out.println("出栈元素:");
            System.out.println(stact.pop());
        }

    }
}

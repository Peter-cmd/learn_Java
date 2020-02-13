package job13.demo0002;
import java.util.Stack;
public class RPNSolution {
    public static int evalRPN(String[] tokens){
        int temp = 0;
        int first = 0;
        int next = 0;
        Stack<Integer> numStack = new Stack<>();
        for (String str : tokens){
            if ("+".equals(str)){
                next = numStack.pop();
                first = numStack.pop();
                temp = first + next;
                numStack.push(temp);
            }else if ("-".equals(str)){
                next = numStack.pop();
                first = numStack.pop();
                temp = first - next;
                numStack.push(temp);
            }else if ("*".equals(str)){
                next = numStack.pop();
                first = numStack.pop();
                temp = first * next;
                numStack.push(temp);
            }else if ("/".equals(str)){
                next = numStack.pop();
                first = numStack.pop();
                temp = first / next;
                numStack.push(temp);
            }else {
                numStack.push(Integer.valueOf(str));
            }
        }
        return numStack.pop();
    }

    public static void main(String[] args){
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result = RPNSolution.evalRPN(tokens);
        System.out.println(result);
    }
}

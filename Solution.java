package Test;
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        //实例化一个栈
        Stack<Character> stack = new Stack<Character>();

        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char ret = s.charAt(i);

            //若字符串第一个字符为右括号
            if (stack.isEmpty()){
                if(ret == '}' || ret == ']' || ret == ')'){
                    return false;
                }
            }

            //处理一般情况
            if (ret == '{' || ret == '[' || ret == '('){
                stack.push(ret);  //将该字符压入栈
            }else{
                if (ret == '}' && stack.peek() == '{') {
                    stack.pop();  //栈顶元素出栈
                }else if (ret == ']' && stack.peek() == '['){
                    stack.pop();
                }else if (ret == ')' && stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;  //匹配失败
                }
            }
        }

        //若栈为空,匹配成功
        if (stack.isEmpty()){  //若栈为空
            return true;
        }

        return false;
    }
}

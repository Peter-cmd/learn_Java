package IsBracketsString;

/**
 * 问题描述: 给定一个字符串,判定其是否是一个合法的括号串
 * 合法括号串: 1.只由括号组成; 2.左括号和右括号一一对应
 *
 * 输入样式: "(()())",6
 *
 * 输出样式: true
 *
 * 输入样式: "()a()()",7
 *
 * 输出样式: false
 *
 * 输入样式: "()(()()",7
 *
 * 输出样式: false
 */
import java.util.*;

public class Parenthesis {
    public static boolean chkParenthesis(String A, int n) {

        char[] chars = A.toCharArray();  //将字符串转化为字符数组

        //定义一个栈,存放括号
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++){  //遍历字符串数组
            if (chars[i] == '('){  //若为左括号进栈
                stack.push(chars[i]);
            }else if(chars[i] == ')'){  //若为右括号栈顶元素出栈,并判断是否是左括号

                if (! stack.empty()) {  //若栈不为空
                    if (stack.pop() == '(') {  //查看栈顶元素是否为左括号
                        continue;  //跳过剩余步骤
                    }
                }else{  //若栈为空,无与之匹配的左括号
                    return false;
                }

            }else{  //当前元素既不是左括号也不是右括号
                return false;
            }
        }

        //判断栈是否为空,不为空表明有未成功匹配的括号
        if (!stack.empty()){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            int n = 0;
            String[] strs1 = str.split(",");
            for (String str1 : strs1){
                String[] strs2 = str1.split("\"");
                for (String str3 : strs2){
                    if (str3.length() == 0){
                        continue;
                    }

                    if (str3.length() > 1){
                        str = str3;
                    }else{
                        n = Integer.parseInt(str3);
                    }

                }
            }
            System.out.println(chkParenthesis(str,n));
        }

    }
}
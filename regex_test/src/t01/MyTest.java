package t01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTest {
    public static void main(String[] args){
        // 要验证的字符串
        String str = "aaabbbcccaaaAAA";
        // 匹配规则
        String regex = "a+|b+|c+|A+";
        // 编译正则表达式
        Pattern p = Pattern.compile(regex);
        // 进行匹配
        Matcher m = p.matcher(str);
        // 若匹配成功
        while (m.find()){
            // 打印匹配结果
            System.out.println("matcher:" + m.group(0));
            System.out.println(m.group(0).length());

        }
    }
}

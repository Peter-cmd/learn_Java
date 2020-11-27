package t01;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTest {
    public static void main(String[] args){
//        // 要验证的字符串
//        String str = "aaabbbcccaaaAAABBB";
//        // 匹配规则
//        String regex = "a+|b+|c+|A+|B+";
//        // 编译正则表达式
//        Pattern p = Pattern.compile(regex);
//        // 进行匹配
//        Matcher m = p.matcher(str);
//        // 若匹配成功
//        while (m.find()) {
//            // 打印匹配结果
//            System.out.println("matcher:" + m.group(0));
//            System.out.println(m.group(0).length());
//
//        }

        String s = "aa";
        String p = "a";
        boolean result = isMatch(s, p);
        System.out.println(result);

    }
    public static boolean isMatch(String s, String p) {
        /*char[] arrayS = s.toCharArray();
        char[] arrayP = p.toCharArray();
        int lengthS = s.length();
        int lengthP = p.length();
        boolean[][] dp = new boolean[lengthS + 1][lengthP + 1];
        dp[0][0] = true;*/
        Pattern p1 = Pattern.compile(p);
        Matcher m = p1.matcher(s);
        System.out.println(m.matches());
        return m.find();


    }
}

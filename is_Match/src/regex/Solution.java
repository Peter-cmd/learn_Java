package regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
class Solution {
    public boolean isMatch(String s, String p) {
        // Pattern p1 = Pattern.compile(p);
        // Matcher m = p1.matcher(s);
        // return m.matches();
        char[] arrayS = s.toCharArray();
        char[] arrayP = p.toCharArray();
        int lengthS = s.length();
        int lengthP = p.length();
        boolean[][] dp = new boolean[lengthS + 1][lengthP + 1];
        dp[0][0] = true;
        // 处理字符串为空,模式不为空的情况
        for (int j = 1; j <= lengthP; j++){
            if (arrayP[j - 1] == '*'){
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= lengthS; i++){
            for (int j = 1; j <= lengthP; j++){
                /*  若模式串中的当前的字符与字符串中当前的字符匹配
                 */
                if (arrayS[i - 1] == arrayP[j - 1]
                        || arrayP[j - 1] == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (arrayP[j - 1] == '*'){ // 若模式中有'*'

                    /* 若模式串 '*' 前面的字符与字符串当前的字符
                       相匹配,即处理 '*' 前面字符所匹配的字符串字
                       符出现 1 次以上的情况
                    */
                    if (arrayP[j - 2] == arrayS[i - 1]
                            || arrayP[j - 2] == '.'){
                        dp[i][j] = dp[i - 1][j];
                    }
                    // 处理 '*' 前面字符在字符串中出现 0 次的情况
                    dp[i][j] |= dp[i][j - 2];
                }

            }
        }
        return dp[lengthS][lengthP];
    }

    public static void main(String[] args){}

}
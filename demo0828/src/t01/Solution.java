package t01;

class Solution {
    public String longestPalindrome(String s) {

        // 获取字符串长度
        int length = s.length();
        if (length == 0){
            return "";
        }
        // 将字符串转化为字符数组
        char[] chars = s.toCharArray();
        // dp[i][j] 表示 s 的 i 到 j 子串是否为字符串
        // 若 i == j, 即表示单个字符 dp[i][j] == true
        // 若 i == j + 1, 即表示两个字符相邻,则 dp[i][j] == (s[i] == s[j]);
        // 若 j - i > 1,
        // dp[i][j] = (s[i] == s[j]) && (dp[i + 1][j - 1]);
        boolean[][] dp = new boolean[length][length];

        // 由于 dp[i][j] 需要用到 i + 1, 所以 i 需要从后向前遍历
        int start = 0;
        int end = 0;
        int result = 0;
        int i = 0;
        int j = 0;
        for (i = length - 1; i >= 0; i--){
            for (j = i; j < length; j++){
                if (i == j){
                    dp[i][j] = true;
                }

                if (i + 1 == j){
                    dp[i][j] = (chars[i] == chars[j]);
                }

                if (j - i > 1){
                    dp[i][j] = ((chars[i] == chars[j]) && dp[i + 1][j - 1]);
                }

                // 判断当前回文串是否是最大的回文串,并记录
                if (dp[i][j]){
                    if ((j - i) >= result){
                        result = j - i;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
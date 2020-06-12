package t01_0612;

public class Solution {
    /**
     * 好多牛牛
     * @param s string字符串
     * @return int整型
     */
    public int solve (String s) {
        // write code here
        String symple = "niuniu";
        int r = s.length();
        int c = symple.length();
        if (r < c){
            return 0;
        }
        int[][] dp = new int[r+1][c+1];
        for (int i = 1; i <= r; i++){
            dp[i][0] = 1;
            for (int j = 1; j <= c; j++){
                if (s.charAt(i - 1) == symple.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    dp[i][j] %= 1000000007;
                }else{
                    dp[i][j] = dp[i - 1][j];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return dp[r][c];
    }
}

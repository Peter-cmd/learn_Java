package dp;

import java.util.*;


public class Solution {
    /**
     * min edit cost
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @param ic int整型 insert cost
     * @param dc int整型 delete cost
     * @param rc int整型 replace cost
     * @return int整型
     */
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        // write code here
        // 1.dp[i][j] 表示将 str1 前 i 个字符编辑成 str2 前 j 个字符的最小代价
        // 2.若 str1[i] 等于 str2[j], dp[i][j] = dp[i - 1][j - 1],无需花费多余的代价
        // 3.若 str1[i] 不等于 str2[j], dp[i][j] = min(dp[i - 1][j - 1] + rc,
        // min(dp[i - 1][j] + dc, dp[i][j - 1] + ic));
        // 4.dp[0][0] = 0,
        //   dp[0][j] = dp[0][j - 1] + ic (1 <= j <= str2.length);
        //   dp[i][0] = dp[i - 1][0] + dc (1<= i <= str1.length);

        int length1 = str1.length();
        int length2 = str2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++){
            dp[i][0] = dp[i - 1][0] + dc;
        }

        for (int j = 1; j <= length2; j++){
            dp[0][j] = dp[0][j - 1] + ic;
        }

        for (int i = 1; i <= length1; i++){
            for (int j = 1; j <= length2; j++){
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + rc,
                            Math.min(dp[i - 1][j] + dc, dp[i][j - 1] + ic));
                }
            }
        }
        return dp[length1][length2];
    }
}
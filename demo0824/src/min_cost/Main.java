package min_cost;

import java.util.*;


public class Main {
    /**
     *
     * @param breadNum int整型
     * @param beverageNum int整型
     * @param packageSum int整型二维数组 每个一维数组中有三个数，依次表示这个包装里面的面包数量、饮料数量、花费
     * @return int整型
     */
    public int minCost (int breadNum, int beverageNum, int[][] packageSum) {
        // write code here
        int length = packageSum.length;


        int[][] dp = new int[breadNum + 1][beverageNum + 1];

        for (int i = 0; i <= breadNum; i++){
            for (int j = 0; j <= beverageNum; j++){
                dp[i][j] = 99999;
            }
        }

        dp[0][0] = 0;

        for (int k = 0; k < length; k++){
            for (int i = breadNum; i >= 0; i--){
                for (int j = beverageNum; j >= 0; j--){
                    dp[i][j] = Math.min(dp[i][j],
                            dp[Math.max(i - packageSum[k][0], 0)][Math.max(j - packageSum[k][1], 0)] + packageSum[k][2]);
                }
            }
        }

        return dp[breadNum][beverageNum];
    }
}

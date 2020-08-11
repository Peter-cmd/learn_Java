package t01;

import java.util.Scanner;

// write your code here
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            Solution.totalCount(m, n);

        }
    }
}

class Solution{
    static void totalCount(int m, int n){
        int[][] dp = new int[m + 1][n + 1];

        for (int j = 0; j <= n; j++){
            dp[0][j] = 1;
        }

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (j > i){
                    dp[i][j] = dp[i][i];
                }else{
                    dp[i][j] = dp[i][j - 1] + dp[i - j][j];
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
package graduation.trip;

import java.util.Scanner;
public class Main{
    private static int findTheLeastCost(int n, int[][] src){
        int m = (int)Math.pow(2, n - 1);
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++){
            dp[i][0] = src[i][0];
        }

        for (int j = 1; j < m; j++){
            for (int i = 0; i < n; i++){
                dp[i][j] = Integer.MAX_VALUE;
                if (((j >> (i - 1)) & 1) == 1){
                    continue;
                }

                for (int k = 1; k < n; k++){
                    if (((j >> (k - 1)) & 1) == 1){
                        dp[i][j] = Math.min(dp[i][j], src[i][k] + dp[k][j ^ (1 << (k - 1))]);
                    }
                }
            }
        }
        return dp[0][m - 1];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[][] src = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    src[i][j] = in.nextInt();
                }
            }
            int result = findTheLeastCost(n, src);
            System.out.println(result);
        }

    }
}
package study;

import java.util.Scanner;

public class Solution {

    public static int solve (int n, int k) {
//        int[][] dp = new int[k + 1][n + 1];
//
//        for (int i = 1; i <= k; i++) {
//            for (int j = 1; j <= n; j++) {
//                dp[i][j] = j;
//            }
//        }
//
//        for (int i = 2; i <= k; i++) {
//            for (int j = 1; j <= n; j++) {
//                for (int z = 1; z < j; z++) {
//                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][z - 1], dp[i][j - z]));
//                }
//            }
//        }
//        return dp[k][n];

        if (n == 0 || k == 0) {
            return 0;
        }
        int nums = (int)(Math.log(n) / Math.log(2) + 1);
        if (k >= nums) {
            return nums;
        }

        int res = 0;
        int[] dp = new int[k];

        while (true) {
            res++;
            int pre = 0;
            for (int i = 0; i < k; i++) {
                int temp = dp[i];
                dp[i] = 1 + dp[i] + pre;
                pre = temp;
                if (dp[i] >= n) {
                    return res;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int floors = 0;
        int chesses = 0;
        while(in.hasNext()) {
            floors = in.nextInt();
            chesses = in.nextInt();
            int result = solve(floors, chesses);
            System.out.println(result);
        }
    }
}

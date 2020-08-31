package t01;

import java.util.Scanner;
public class Solution{

    private static void findLestStamps(int sum, int n, int[] stamps){
        // dp[j] 表示组成 j 的最少邮票张数 (stamps[i] <= j <= n)
        // dp[j] = min(dp[j], dp[i - stamps[j]] + 1);
        // 初始化 dp[i] = 100  (0 < i <= sum); dp[0] = 0;
        int[] dp = new int[sum + 1];
        for (int i = 1; i <= sum; i++){
            dp[i] = 100;
        }

        for (int i = 0; i < n; i++){
            for (int j = sum; j >= stamps[i]; j--){
                dp[j] = Math.min(dp[j], dp[j - stamps[i]] + 1);
            }
        }
        System.out.println(dp[sum] < 100 ? dp[sum] : 0);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            // 获取数字总值
            int sum = in.nextInt();
            // 获取邮票张数
            int n = in.nextInt();
            // 获取各邮票的面值
            int[] stamps = new int[n];
            for (int i = 0; i < n; i++){
                stamps[i] = in.nextInt();
            }
            findLestStamps(sum, n, stamps);
        }
    }
}
package t01;

import java.util.Scanner;
public class Main{
    private static void magicalPoket(int n, int[] nums){
        // 排除非法输入
        if (n < 1 || n > 20){
            System.out.println(0);
        }

        int[] dp = new int[40 + 1];
        // 初始组成体积为 0 的组合只有 1 种
        dp[0] = 1;
        for (int i = 0; i < n; i++){
            for (int j = 40; j >= nums[i]; j--){
                // 总体积为 j 的组合数已有 dp[j] 种, 此时新出现一个体积为
                // nums[i] 的物体,则总的方法数为 dp[j] + dp[j - nums[i]];
                dp[j] += dp[j - nums[i]];

            }
        }
        System.out.println(dp[40]);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }
            magicalPoket(n, nums);
        }
    }
}
package demo001;

import java.util.Scanner;

/**
 * 问题描述:一个数组有 N 个元素,求连续子数组的最大和.例如:
 * [-1,2,1],和最大的连续子数组[2,1],其和为3
 *
 * 输入描述:
 *   输入为两行.第一行一个整数n(1 <= n <= 100000),表示一
 * 共有 n 个元素 第二行为 n 个数,即每个元素,每个整数都在 32
 * 位 int 范围内.以空格分隔.
 *
 * 输出描述:
 *   所有连续子数组中和最大的值.
 *
 * 输入:
 * 3 -1 2 1
 * 输出:
 * 3
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //记录数组信息
        while(in.hasNext()){
            int n = Integer.parseInt(in.next());
            long[] nums = new long[n];
            int index = 0;
            for (int i = 0; i < n; i++){
                nums[i] = Long.parseLong(in.next());
            }
            maxSumOfSubArray(n, nums);
        }
    }

    //求连续子数组中和的最大值
    private static void maxSumOfSubArray(int n, long[] nums) {
        //处理数组为空的情况
        if (n == 0){
            return;
        }
        //处理只有一个元素的情况
        if (n == 1){
            System.out.println(nums[0]);
            return;
        }

        //f(i) 表示以下标为 i 的元素结尾的子数组和的最大值
        //考虑所有子数组,求最大值
        long[] dp = new long[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++){
            //若当前的元素小于 0, 当前的子数组和的最大值为 dp[i - 1]
            if (nums[i] < 0){
                dp[i] = dp[i - 1];
            }
            //若当前的元素大于 0, 且其前一个元素也大于 0
            if (nums[i] > 0 && nums[i - 1] >= 0){
                dp[i] = nums[i] + dp[i - 1];
            }
            //若当前的元素小于 0, 且其之前的一个元素小于 0
            if (nums[i] > 0 && nums[i - 1] < 0){
                dp[i] = Math.max(nums[i], dp[i - 1]);
            }

        }
        System.out.println(dp[n - 1]);
    }
}

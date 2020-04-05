package demo002;



import java.util.Scanner;

/**
 * 问题描述:给定一个有n个正整数的数组A和一个
 * 整数sum,求选择数组A中部分数字和为sum的方
 * 案数.
 * 当两种选取方案有一个数字的下标不一样,我们就
 * 认为是不同的组成方案.
 *
 *
 * 输入描述:
 * 输入为两行:
 * 第一行为两个正整数n(1<=n<=1000),
 * sum(1<=sum<=1000)
 * 第二行为n个正整数A[i](32位整数),以空格隔开.
 *
 * 输出描述:
 * 输出所求的方案数
 *
 * 输入:
 * 5 15 5 5 10 2 3
 * 输出:
 * 4
 */

public class Main {

    //main方法, 主要负责数的输入
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int sum = in.nextInt();
        int[] nums = new int[length];  //存储输入的元素
        int[] sums = new int[sum + 1];  //保存组成 j 的方案数
        sums[0] = 1;  //初始化组成 0 的方案只有一种
        for (int i = 0; i < length; i++) {  //依次计算与 nums[i] 组成 j 的方案数
            nums[i] = in.nextInt();  //保存 nums[i]
            for (int j = sum; j >= 0; j--){  //计算组成 j 的方案数
                if (j >= nums[i]){  //若 nums[i] <= j
                    sums[j] += sums[j - nums[i]];  //组成 j 的方案数等于组成 j - nums[i[ 的方案数
                }
            }
        }

        System.out.println(sums[sum]);


    }
}
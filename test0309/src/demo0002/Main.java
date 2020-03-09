package demo0002;

import java.util.Scanner;

/**
 * 问题描述: 正整数A和正整数B的最小公倍数是指能被A和B整除的最小的正整数值,
 * 设计一个算法,求输入A和B的最小公倍数
 *
 * 输入描述:输入两个正整数A和B
 *
 * 输出描述:输出A和B的最小公倍数
 *
 * 输入样例:5 7
 *
 * 输出样例:35
 */

public class Main {
    public static int leastCommonMultiple(int[] nums){
        int max = nums[0];
        if (max < nums[1]){
            max = nums[1];
        }

        int product = nums[0] * nums[1];
        for (int i = max; i < product; i++){
            if (i % nums[0] == 0 && i % nums[1] == 0){
                return i;
            }
        }
        return product;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            String[] substring = str.split(" ");
            int[] nums = new int[2];
            int i = 0;
            for (String num : substring){
                nums[i++] = Integer.parseInt(num);
            }
            int result =leastCommonMultiple(nums);
            System.out.println(result);
            i = 0;
        }
    }

}

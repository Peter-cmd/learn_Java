package demo001;

import java.util.Scanner;

/**
 * 问题描述:给定一个长度为N(N>1)的整型数组A,可以将A划分成
 * 左右两部分,左部分A[0..K],右部分A[K+1..N-1],K可以取值
 * 的范围是[0,N-2].求这么多划分方案中,左部分中的最大值减去
 * 右部分最大值的绝对值,最大是多少?
 * 给定整数数组A和数组的大小n,请返回题目所求的答案.
 *
 * 测试样例:
 * [2,7,3,1,1],5
 *
 * 返回: 6
 *
 */
public class MaxGap {
    public static int findMaxGap(int[] A, int n){
        //处理数组为 0 的情况
        if (n == 0){
            return 0 ;
        }

        if (n == 1){
            return A[0];
        }

        if (n == 2){
            return Math.abs(A[1] - A[0]);
        }
        //保存K的取值范围内各方案的结果
        //即result[i]表示以 A[i] 分割的情况下,
        //左部分中的最大值减去右部分最大值的绝对值.
        int[] result = new int[n - 1];
        int maxResult = Integer.MIN_VALUE;
        //保存以 i 分割右部分最大的值
        int[] rightMaxTable = new int[n - 1];
        //初始化右部分只有一个数据的情况
        rightMaxTable[n - 2] = A[n - 1];
        ////rightMaxTable[i] 保存[i + 1..N - 1]中的最大值
        for (int i = n - 3; i >= 0; i--){
            rightMaxTable[i] = Math.max(A[i + 1], rightMaxTable[i + 1]);
        }

        int leftMax = A[0];
        int rightMax = Integer.MIN_VALUE;
        //每种分割方案
        for (int i = 0; i < n - 1; i++){
            //判断左部分最大值
           leftMax = Math.max(leftMax, A[i]);

            //判断右部分的最大值
            rightMax = rightMaxTable[i];
            result[i] = Math.abs(leftMax - rightMax);
        }

        //查找最大的结果
        for (int i = 0; i < n - 1; i++){
            maxResult = Math.max(maxResult, result[i]);
        }
        return maxResult;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int index = 0;
            int n = Integer.parseInt(in.next());
            int[] array = new int[n];
            while (index < n) {
                array[index++] = Integer.parseInt(in.next());
            }
            int result = findMaxGap(array, n);
            System.out.println(result);
        }

    }
}

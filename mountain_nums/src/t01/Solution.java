package t01;

import java.util.*;


public class Solution {
    /**
     * 返回最大山峰序列长度
     * @param numberList int整型一维数组 给定的序列
     * @return int整型
     */
    public int mountainSequence (int[] numberList) {
        // write code here
        int length = numberList.length;
        // 用以从左向右查找最大递增序列长度
        int[] dp1 = new int[length];
        // 用以从右向左查找最大递增序列长度
        int[] dp2 = new int[length];

        for (int i = 0; i < length; i++){
            dp1[i] = 1;
            for (int j = 0; j < i; j++){
                if (numberList[j] < numberList[i]){
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        for (int i = length - 1; i >= 0; i--){
            dp2[i] = 1;
            for (int j = length - 1; j > i; j--){
                if (numberList[j] < numberList[i]){
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < length; i++){
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }
        return max;
    }
}
package demo004;
/**
 * 问题描述: 给定一个数组A[0,1,...,n-1].请构建一个数组B[0,1,...,n-1],
 *      其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1].
 */

import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        for (int i = 0; i < length; i++){
            B[i] = divide(A, i, length);
        }
        return B;
    }


    private static int divide(int[] A, int index, int length){
        int result = 0;
        int leftResult = 1;
        int rightResult = 1;
        for (int i = 0; i < index; i++){
            leftResult *= A[i];
        }

        for (int j = index + 1; j < length; j++){
            rightResult *= A[j];
        }

        result = leftResult * rightResult;
        return result;
    }
}
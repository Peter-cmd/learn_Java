/**
 * 输入数据:[1,2,3,4,5,6,7,0],8
 * 输出数据:7
 */

import java.util.*;
public class Antiorder {
    //计算逆序对的个数
    public int count(int[] A, int n){
        int count = 0;
        count = megerMethod(A, 0, n, count);
        return count;
    }

    //归并计算逆序对的个数
    private int megerMethod(int[] A, int l, int r, int count) {
        //若只有一个元素返回
        if (l + 1 >= r){
            return 0;
        }

        //计算中间值
        int mid = (l + r) / 2;

        //向左分治
        megerMethod(A, l, mid, count);
        //向右分治
        megerMethod(A, mid, r, count);
        //处理数据
        int i = l;
        int j = mid;
        while (i < mid && j < r){
            if (A[i++] > A[j++]){  //若数组前一个数比后一个大
                count++;  //逆序对个数加1
            }
        }
        return count;  //返回逆序对个数
    }
}

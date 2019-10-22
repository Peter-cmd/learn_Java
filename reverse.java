package com.test;
import java.util.Arrays;
public class Test {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        reverse(arr);  //调用逆置数组方法
        System.out.println(Arrays.toString(arr));
    }
    //逆置数组方法
    public static void reverse(int[] arr){
        int left = 0;  //left取数组最左边元素下标
        int right = arr.length - 1;  //right取数组最右边元素下标
        while (left < right){
            //交换下标为left和right的两个元素的值
            int temp;
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;  //left加1
            right--;  //right减1
        }
    }
}

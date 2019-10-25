package com.test;
import java.util.Scanner;
public class Test {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        Scanner in = new Scanner(System.in);
        System.out.println("请输入您要找的数:");
        int toFind = in.nextInt();  //接收要查找的数据
        seek(arr,toFind);  //调用查找方法
        binarrySeek(arr,toFind);
    }
    //查找方法
    public static int seek(int[] arr, int tofind){
        for (int i = 0; i < arr.length; i++){   //遍历数组
            if (arr[i] == tofind){  //若成功找到要找的数
                System.out.println("您要找的数是:" +arr[i]);
                return 1;
            }
        }
        System.out.println("抱歉,未找到您要找的数.");  //未成功找到要找的数
        return 0;
    }
    //二分查找方法
    public static int binarrySeek(int[] arr,int tofind){
        int mid;
        int left = 0;  //left取数组中最左边一个元素的下标
        int right = arr.length - 1;  //right取数组中最右一个元素的下标
        while(left <= right) {  //当left小于right
            mid = (left + right) / 2;  //mid取left和right最中间元素的下标
            if (arr[mid] < tofind) {  //若要查找的元素比arr[mid]大
                left = mid + 1;  //left的值更新为mid加1
            } else if (arr[mid] > tofind) {
                right = mid - 1;  //right的值更新为mid减1
            } else {  ///若找到了要查找的数
                System.out.println("您要找的数是:" + arr[mid]);
                return 1;
            }
        }
        System.out.println("抱歉,未找到您要找的数.");  //未找到要查找的数
            return 0;
    }
}

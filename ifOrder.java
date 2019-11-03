package com.test;
public class Test {
    public static void main(String[] args){
        int[] arr = {1,2,8,4,5,6};
        boolean ret = ifOrder(arr);  //调用判断数组是否有序方法
        if (ret == true){  //若方法的返回值为true
            System.out.println("该数组是有序数组.");
        }else {  //若方法的返回值为false
            System.out.println("该数组是无序数组.");
        }
    }
    //判断数组是否有序方法
    public static boolean ifOrder(int[] arr){
        if (arr[0] > arr[1]){  //若该数组是降序的
            for (int i = 0;i< arr.length - 1;i++){  //遍历数组
                if (arr[i] < arr[i+1]){  //若该数组中出现后一个元素比前一个元素大
                    return false;
                }
            }
        }else {  //若该数组是升序的
            for (int i = 0;i < arr.length - 1; i++){  //遍历数组
                if (arr [i] > arr[i + 1]){  //若该数组中出现后一个元素比前一个元素小
                    return false;
                }
            }
        }
        return true;
    }
}

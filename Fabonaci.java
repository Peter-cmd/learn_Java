package com.test;
import java.util.Scanner;
public class Test {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入您想要的第N个斐波那契数中的N:");
        int n = in.nextInt();  //接收一个正整数
        //System.out.println(noRecursionFibonacci(n));  //调用找第N个斐波那契数方法
        System.out.println(fibonacci(n));  //调用找第N个斐波那契数方法
    }
    //找第N个斐波那契数方法
    public static long fibonacci(int n){
        if (n == 1 || n == 2){ //递归边界
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);  //递归调用方法自身
    }
    public static long noRecursionFibonacci(int n){
        long f1 = 1;  //第一项斐波那契数
        long f2 = 1;  //第二项斐波那契数
        if (n == 0){
            return 0;
        }
        while (n > 2){  //从3项开始计算斐波那契数
            f2 = f1 + f2;  //某一项的斐波那契数是其前两项斐波那契数的和
            f1 = f2 - f1;  //f1的值更新为该项斐波那契数的前一项斐波那契数的值
            n--;  //斐波那契数从第3项开始逐步向第n项靠近
        }
        return f2;  //反回要找的第n项斐波那契数
    }
}

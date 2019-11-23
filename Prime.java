package com.Test;
import java.lang.Math;  //导入包
import java.util.Scanner;  //导入包
public class Test3 {  //定义Test3类
    //主函数
    public static void main(String[] args){
        int i = 2;  //用以遍历2到要判定的数的平方根
        double result;  //保存要判定的数的平方根
        Scanner in = new Scanner(System.in);  //创建Scanner类的对象
        System.out.println("请输入一个整数:");
        int num = in.nextInt();  //调用nextInt()方法
        if (num == 1 || num == 0){
            System.out.println( num +"不是素数也不是合数.");
        }
         result = Math.sqrt(num);  //计算并保存num的平方根
        while(i <= result){  //当i小于result
            if(num % i == 0){  //若num能被i整除
                System.out.println(num+ "不是素数,是合数.");
                break;  //跳出循环
            }
            ++i;  //i加1
        }
        if (i > result && num != 0 && num != 1){
            System.out.println(num+ "是素数,不是合数.");
        }
    }
}

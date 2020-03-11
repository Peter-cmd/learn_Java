package demo004;

import java.util.Scanner;

/**
 * 问题描述: 输入一个正整数n,求n!(即n的阶乘)末尾有多少个0;
 * 比如:n=10;n!=3628800,所以答案为2
 *
 * 输入描述:输入一行,n(1<=n<=1000)
 * 输出描述:输出一个整数
 *
 *
 * 输入:10
 * 输出:2
 *
 */

public class Main {

    private static int countOfZero(long num){
        int count = 0;
        //求num的阶乘
        long result = factorial(num);
        while(result != 0){
            if (result % 10 == 0){
                count++;
            }else{
                break;
            }
            result /= 10;
        }
        return count;
    }

    private static long factorial(long num){
        if (num == 1){
            return 1;
        }
        return num * factorial(num - 1);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            long num = in.nextLong();
            long result = countOfZero(num);
            System.out.println(result);
        }
    }
}

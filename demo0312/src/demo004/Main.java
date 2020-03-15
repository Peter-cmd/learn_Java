package demo004;

import java.util.Scanner;

/**
 * 问题描述:
 *Fibonacci数列是这样定义的: F[0] = 0 F[1] = 1
 * for each i >= 2; F[i] = F[i - 1] + F[i - 2]
 * 因此,Fibpnacci数列就形如: 0, 1, 1, 2, 3, 5, 8, 13, ... ,
 * 在Fibonacci中的数,我们称为Fibonacci数.给你一个N,你想
 * 让其变为一个Fibonacci数,每一步你可以把当前数字X 变为X-1
 * 或者X+1,现在给你一个数N求最少需要多少步可以变为Fibonacci数.
 *
 * 输入描述:
 *输入一个正整数N(1 <= N <= 1,000, 000)
 *
 * 输出描述:
 *输出一个最小的步数,变为Fibinacci数
 *
 * 输入:
 * 15
 *
 * 输出:
 * 2
 */


public class Main {

    private static int findLeastStep(int num){

        int step = 0;
        int prev = 0;
        int cur = 1;
        int less = 0;
        int more = 0;
        while (true){
            if (cur >= num){
                break;
            }
            cur = prev + cur;
            prev = cur - prev;
        }

        less = cur - num;
        more = num - prev;

        if (less < more){
            step = less;
        }else{
            step = more;
        }

        return step;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int num = in.nextInt();
            int result = findLeastStep(num);
            System.out.println(result);
        }
    }
}

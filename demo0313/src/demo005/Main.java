package demo005;

import java.util.Scanner;

/**
 * 问题描述:给定一个k位整数N,请编写程序统计每种不同的个位
 * 数字出现的次数.例如:给定N=100311,则有2个0,3个1,和1个3.
 *
 * 输入描述:每个输入包含1个测试用例,即一个不超过1000位的正整数N.
 *
 * 输出描述:对N中每一种不同的个位数字,以D:M的格式在一行中输出改位
 * 数字D及其在N中出现的次数.要求按D的升序输出.
 *
 * 输入:
 * 100311
 *
 * 输出:
 * 0:2
 * 1:3
 * 3:1
 */
public class Main {

    public static void countOfNum(String str){
        char[] chars = str.toCharArray();
        int[] num = new int[10];
        int length = chars.length;

        for (int i = 0; i < length; i++){
            num[chars[i] - 48]++;
        }

        for (int i = 0; i < 10; i++){
            if (num[i] != 0){
                System.out.println(i + ":" + num[i]);
            }
        }
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            countOfNum(str);
        }

    }
}

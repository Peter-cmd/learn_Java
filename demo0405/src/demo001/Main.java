package demo001;

import java.util.Scanner;

/**
 *问题描述: 今年公司年会的奖品特别给力,但获奖的
 * 规矩却很奇葩:
 * 1.首先,所有人员都将一张写有自己名字的字条
 * 放入抽奖箱中;
 * 2.待所有字条加入完毕,每人从箱中取一个字条;
 * 3.如果抽到的字条上写的就是自己的名字,那么"
 * 恭喜你,中奖了!'
 * 现在告诉你参加晚会的人数,请你计算有多少概
 * 率出现无人获奖?
 *
 *
 * 输入描述:
 * 输入包含多组数据,每组数据包含一个正整数n(2<=n
 * <=20).
 *
 * 输出描述:
 * 对应每一组数据,以"xx.xx%"的格式输出发生无
 * 人获奖的概率.
 *
 * 输入:
 * 2
 * 输出:50.00%
 */


// write your code here


import java.util.Scanner;
public class Main {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            if (n == 1 || n == 0){
                System.out.println("100.00%");
                continue;
            }
            long[] n1 = new long[n + 1];
            long[] n2 = new long[n + 1];
            n1[0] = 0;
            n2[0] = 0;
            n1[1] = 0;
            n2[1] = 1;
            n1[2] = 1;
            n2[2] = 2;
            for (int i = 3; i <= n; i++){  //差错排列算法
                //1.设有 n 个数分别用 1~n 标号,分别放入标有 1~n 的 n 个房间,
                // 求每个数的房间都不对应自己标号的方案数,用 f(n) 表示 n 个房
                // 间的错排方案数;
                //2.设第 n 个数放入第 k 个房间;
                //3.由 2 得,第 k 个数的放入位置有两种情况:
                //1>第 k 个数放入第 n 个房间,此时可供差错排列的房间还有 n-2 个;
                //2>第 k 个数放入 1~n-1 中的任意一个房间(即不放入 第 n 个房间),
                // 此时可供差错排列的房间还有 n-1 个;
                //4.放入第 n 个数后,还有 n-1 个数待排序;
                //综上所述: f(n) = (n-1)*(f(n-1)+f(n-2));
                n1[i] = (i - 1) * (n1[i - 1] + n1[i -2]);
            }

            //总共有 n! 种方案
            for (int i = 3; i <= n; i++){
                n2[i] = i * n2[i - 1];
            }
            float result = (float)(1.0 * n1[n] / n2[n]);
            result *= 100;
            System.out.printf("%.2f%s", result,"%");
            System.out.println();
        }
    }
}
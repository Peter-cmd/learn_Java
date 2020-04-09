package demo001;

import java.util.Scanner;

/**
 * 问题描述: 如果你是哈利*波特迷,你会知道魔法世界有它
 * 自己的货币系统--就是海格告诉哈利的:"十七个银西可
 * (Sickie)兑一个加隆(Galleon),二十九个纳特(Knut)
 * 兑一个西可,很容易."现在,给定哈利应付的价钱P和他实付
 * 的钱A,你的任务是写一个程序来计算他应该被找的零钱.
 *
 * 输入描述:
 * 输入在 1 行中分别给出P和A, 格式为"Galleon.Sickle.
 * Knut",其间用1个空格分隔.这里Galleon是[0, 10000000]
 * 区间的整数,Sickle是[0,17]区间内的整数,Kunt是[0,29]
 * 区间内的整数.
 *
 * 输出描述:
 * 在一行中用与输入同样的格式输出哈利应该被找的零钱.如果他
 * 没带够钱,那么输出的应该是负数.
 *
 * 输入:
 * 10.16.27 14.1.28
 *
 * 输入:
 * 3.2.1
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //输入应付金额
        String[] ap = in.next().split("\\.");
        //输入实付金额
        String[] ar = in.next().split("\\.");
        //将金额转换成 Long 类型的
        long[] aps = {
                Long.parseLong(ap[0]),
                Long.parseLong(ap[1]),
                Long.parseLong(ap[2]),
        };

        long[] ars = {
                Long.parseLong(ar[0]),
                Long.parseLong(ar[1]),
                Long.parseLong(ar[2]),
        };

        //将应付和实付金额都转换为纳特
        Long longAp = toKnut(aps[0], aps[1], aps[2]);
        Long longAr = toKnut(ars[0], ars[1], ars[2]);
        Long sub = longAr - longAp;

        if (sub < 0){
            System.out.print("-");
            sub = -sub;
        }

        //将结果转回相应的单位
        System.out.format("%d.%d.%d\n",
                sub / (17 * 29),
                sub % (17 * 29) / 29,
                sub % (17 * 29) % 29);
    }

    private static Long toKnut(long ap, long ap1, long ap2) {
        long knut = ap * 17 * 29 + ap1 * 29 + ap2;
        return knut;
    }
}

package demo001;

import java.util.Scanner;

/**
 * 问题描述: 输入球的中心点和球上某一点的坐标,计算
 * 球的半径和体积
 *
 * 输入描述:
 * 球的中心点和球上某一点的坐标,以如下形式输入
 * :x0 y0 z0 x1 y1 z1
 *
 * 输出描述:
 * 输入可能有多组,对于每组输入,输出球的半径和体积,
 * 并且结果保留三位小数
 *
 * 为避免精度问题,PI值使用 arccos(-1).
 *
 * 输入:
 * 0 0 0 1 1 1
 *
 * 输出:
 * 1.732 21.766
 */


public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //保存中心点坐标
        int[] centre = new int[3];
        int i;
        //保存任意点的坐标
        int[] spot = new int[3];
        int j;
        //
        while (in.hasNext()){
            i = 0;
            j = 0;
            while (i < 3){
                centre[i++] = Integer.parseInt(in.next());
            }
            while (j < 3){
                spot[j++] = Integer.parseInt(in.next());
            }
            String result = calculate(centre, spot);
            System.out.println(result);
        }
    }

    private static String calculate(int[] centre, int[] spot) {
        //1.计算半径:
        // 1>半径即球上任意一点到球心的直线距离,利用欧式距离(基于勾股定理)求解
        // 2>勾股定理: 假设直角三角形中斜边为 c,其余两条直角边为 a, b, 则
        //    c的平方 = a 的平方 + b 的平方

        //定义半径
        double r = 0;
        //利用勾股定理和欧式距离求半径
        int x = Math.abs(centre[0] - spot[0]);
        int y = Math.abs(centre[1] - spot[1]);
        int z = Math.abs(centre[2] - spot[2]);
        r = Math.sqrt((x * x + y * y + z * z));

        //2.计算球的体积:
        // 1>球的体积公式为: V = (4/3) * π * r的三次方
        // 2> π 用 arccos(-1)确定
        double v = (4.0 / 3) * Math.acos(-1) * Math.pow(r, 3);
        String string = String.format("%.3f %.3f", r, v);
        return string;
    }
}

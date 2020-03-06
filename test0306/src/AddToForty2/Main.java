package AddToForty2;

import java.util.Scanner;

/**
 * 问题描述: 有n(1 <= n <= 20)件物品和一个容积为40的背包
 * 物品的体积分别为: w1, w2, w3 ...
 * 现在要找出n件物品共有多少种组合方式使其容积和为40
 *
 *
 * 输入样例:
 * 物品件数: 3
 * 物品对应的体积:
 * 20
 * 20
 * 20
 *
 * 输出样例:
 * 3
 */
public class Main {


    public static int toFindCount(int[] goods, int num, int box){
        int count = 0;


        return count;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] goods = new int[20];  //存放物品信息
        int box = 40;  //盒子大小
        int num = -1;  //物品数量
        int i = 0;  //
        while(in.hasNext()){
            if(num == -1)
                num = in.nextInt();  //记录物品数量
            goods[i++] = in.nextInt();
            if (i == num)  //物品信息录入结束
                break;
        }
        int result = toFindCount(goods, num, box);
        System.out.println(result);
    }
}

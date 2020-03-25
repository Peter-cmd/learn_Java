package demo003;

import java.util.Scanner;

/**
 问题描述: 有一只兔子,从出生第3个月起每个月都生一只兔子,小兔子长到第三个月后每个月
 又生一只兔子,假如兔子都不死,问某个月的兔子总数为多少?

 public static int getTotalCount(int monthCount){
 return 0;
 }


 输入描述:
 输入int型表示month
 输出描述:
 输出兔子总数int型


 输入: 9
 输出: 34
 */

public class Main{

    /**
     *
     * @param monthCount  兔子繁殖的月数
     * @return  返回某月的兔子数
     */

    public static int getTotalCount(int monthCount){
        int adult = 1;
        int totleCount = 1;

        return 0;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int monthCount = in.nextInt();
            int result = getTotalCount(monthCount);
            System.out.println(result);
        }
    }
}

package demo002;

import java.util.ArrayList;
import java.util.Scanner;

/**
 问题描述: 读入N名学生读的成绩,将获得某一给定分数的学生人数输出.

 输入描述:
 测试输入包含若干测试用例, 每个测试用例的格式为
 第一行: N
 第二行: N名学生的成绩,相邻两数字用一个空格间隔.
 第三行: 给定的分数

 当读到N=0是输入结束.其中N不超过1000,成绩分数为(包含)0到100之间
 的一个整数.

 输出描述:
 对每个测试用例,将获得给定分数学生人数输出.

 输入样例:
 3
 80 60 90
 60
 2
 85 66
 0
 5
 60 75 90 55 75
 75
 0

 输出样例:
 1
 0
 2

 */
public class TotalScore {

    private static int count(String[] score, String markScore){
        int count = 0;
        for (String str : score){
            if (str.equals(markScore)){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> results = new ArrayList<>();
        int n = 0;
        String markScore = null;
        while (in.hasNext()){
            n = Integer.parseInt(in.nextLine());
            if (n == 0){
                break;
            }
            //读取所有学生分数
            String score = in.nextLine();
            //记录每一个学生分数
            String[] scores = score.split(" ");
            //要匹配的分数
            markScore = in.nextLine();
            //返回结果
            int result = count(scores, markScore);
            results.add(result);
        }

        for (Integer result : results){
            System.out.println(result);
        }
    }
}

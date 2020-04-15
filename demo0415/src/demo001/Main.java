package demo001;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 问题描述：
 * 有一个有很多木棒构成的集合，每个木棒有对应的长度，请问能否
 * 用集合中的这些木棒以某个顺序首尾相连构成一个面积大于 0 的
 * 简单多边形且所有木棒都要用上，简单多边形即不会自交的多边形。
 * 初始集合是空的，有两种操作，要么给集合添加一个长度为 L 的木
 * 棒，要么删去集合中已经有的某个木棒。每次操作结束后你都需要告
 * 知是否能用集合中的这些木棒构成一个简单多边形。
 *
 * 输入描述：
 * 每组测试用例仅包含一组数据，每组数据第一行为一个正整数 n 表示
 * 操作的数量（1 <= n <= 50000), 接下来有 n 行, 每行第一个整数
 * 为操作类型 i (i 属于 (1, 2)),第二个整数为一个长度 L (1 <= L
 * <= 1,000,000,000).如果 i = 1 代表在集合内插入一个长度为 L 的
 * 木棒,如果 i = 2 代表删去在集合内的一根长度为 L 的木棒.输入数据保
 * 证删除时集合中必定存在长度为 L 的木棒,且任意操作后集合都是非空的.
 *
 *
 * 输出描述:
 * 对于每一次操作结束有一次输出,如果集合内的木棒可以构成简单多边形,
 * 输出 "Yes", 否则输出"No".
 *
 * 输入:
 * 5
 * 1 1
 * 1 1
 * 1 1
 * 2 1
 * 1 2
 *
 *
 * 输出:
 * No
 * No
 * Yes
 * No
 * No
 */
public class Main {

    private static ArrayList<Long> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        //录入用户的输入
        while (n > 0){
            int operation = Integer.parseInt(in.next());
            long length = Long.parseLong(in.next());
            //根据用户的需要执行相应的操作
            if (operation == 1){
                list.add(length);
            }else{
                list.remove(length);
            }
            ifFormPolygon();
           n--;
        }

    }

    //判断集合中的变是否能组成多边形
    private static void ifFormPolygon() {
        //若集合为空或可用边小于 2, 则直接判断无法构成多边形
        if (list.isEmpty() || list.size() < 3){
            System.out.println("No");
            return;
        }


        int length = list.size();
        long max = 0L;
        boolean mark = false;
        //查找当前集合中最大的边
        for (int i = 0; i < length; i++){
            max = Math.max(max, list.get(i));
        }

        //已知若集合中边数大于 2 的情况下;
        //若除最大边外的所有边的和,大于最大边,
        //则该集合中的元素可以构成多边形,反之,
        //则不能.
        long sum = 0L;
        for (int i = 0; i < length; i++){
            if (list.get(i) == max && mark == false){
                mark = true;
                continue;
            }
            sum += list.get(i);
        }
        if (sum > max){
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
    }
}

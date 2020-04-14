package demo002;

import java.util.Scanner;

/**
 * 问题描述:
 * 小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值
 * P跳出这个地下迷宫.为了让问题简单,假设这是一个 n*m 的格子迷宫,迷宫
 * 每个位置为 0 或者 1, 0 代表这个位置有障碍物.小青蛙到达不了这个位
 * 置; 1 代表小青蛙可以到达的位置.小青蛙初始在(0,0)位置.地下迷宫的出
 * 口在(0, m - 1)(保证这两个位置都是1,并且保证一定有起点到终点可达的
 * 路径),小青蛙在迷宫中水平移动一个单位距离需要消耗 1 点体力值,向上爬
 * 一个单位距离需要消耗 3 个单位的体力值,向下移动不消耗体力值,当小青蛙
 * 的体力值等于 0 的时候还没有到达出口,小青蛙将无法逃离迷宫.现在需要你
 * 帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(0, m - 1)位置).
 *
 * 输入描述:
 * 输入包括 n + 1 行:
 * 第一行为三个整数n, m(3 < = m, n <= 10), P(1 <= P <= 100)
 * 接下来的 n 行:
 * 每行 m 个 0 或者 1, 以空格分隔
 *
 * 输出描述:
 * 如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;
 * 如果不能逃离迷宫,则输出"Can not escape!". 测试数据保证答案唯一.
 *
 * 输入:
 * 4 4 10 1 0 0 1 1 1 0 1 0 1 1 1 0 0 1 1
 *
 * 输出:
 * [0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int indexI = 0;
        int indexJ = 0;
        while (in.hasNext()){
            //录入迷宫边界和青蛙的体力值
            int n = Integer.parseInt(in.next());
            int m = Integer.parseInt(in.next());
            int P = Integer.parseInt(in.next());
            int[][] map = new int[n][m];
            //录入迷宫信息
            for (indexI = 0; indexI < n; indexI++){
                for (indexJ = 0; indexJ < m; indexJ++){
                    map[indexI][indexJ] = Integer.parseInt(in.next());
                }
            }
            minPath(P, map);
        }
    }

    private static int[][] DIR = {{-1, 0}, {1, 0}, {0, 1}};
    //计算最短路径
    private static void minPath(int p, int[][] map) {
        int n = map.length;
        int m = map[0].length;
        int result = 0;

    }

    //计算当前节点到目标节点的曼哈顿距离
    private static int manhattanDistance(int sourceI, int sourceJ, int targetI, int targetJ){
        
    }

}

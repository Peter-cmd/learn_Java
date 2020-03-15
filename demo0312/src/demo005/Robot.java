package demo005;

/**
 * 问题描述:
 * 有一个XxY的网格,一个机器人只能走格点且只能向右
 * 或向下走,要从左上角走到右下角.请设计一个算法,计
 * 算机器人有多少种走法.
 * 给定两个正整数int x, int y,请返回机器人的走法数目.
 * 保证x + y小于等于12.
 *
 * 测试样例:
 * 2,2
 *返回: 2
 */

//import java.util.*;
//
//public class Robot {
//    //规定机器人向下和向右走
//    private static final int[][] DIRS = {{1 ,0}, {0, 1}};
//    private static int count = 0;
//    public int countWays(int x, int y) {
//
//        int[][] map = new int[x][y];  //创建地图
//        map[x- 1][y - 1] = 1;  //地图的结束标记
//        dfs(map, 0, 0, x, y);
//        return count;
//    }
//
//    private static void dfs(int[][] map, int i, int j, int r, int c){
//        if (map[i][j] == 1){
//            count++;
//            return;
//        }
//
//        int x = 0;
//        int y = 0;
//
//        for (int[] step: DIRS){
//            x = i + step[0];
//            y = j + step[1];
//            if (x >= 0 && x < r
//                    && y >= 0 && y < c){
//                dfs(map, x, y, r, c);
//            }
//        }
//    }
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            Robot robot = new Robot();
//            String str = in.nextLine();
//            String[] subString = str.split(",");
//            int x = Integer.parseInt(subString[0]);
//            int y = Integer.parseInt(subString[1]);
//            int result = robot.countWays(x, y);
//            System.out.println("返回: " + result);
//            Robot.count = 0;
//        }
//    }
//}
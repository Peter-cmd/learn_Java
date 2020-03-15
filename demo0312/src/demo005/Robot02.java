package demo005;

import java.util.Scanner;
import java.util.Stack;

public class Robot02 {


    public int countWays(int x, int y) {

        //规定机器人向下和向右走
        final int[][] DIRS = {{1 ,0}, {0, 1}};
        int count = 0;  //用于统计路径数量
        int[][] map = new int[x][y];  //创建地图
        map[x- 1][y - 1] = 1;  //地图的结束标记
        Stack<Integer> stack = new Stack<>(); //用于存放数组下标
        int i, j;
        int TagI, TagJ;
        //将数组第一个元素下标入栈
        stack.push(0);
        stack.push(0);
        while (!stack.empty()){
            i = stack.pop();
            j = stack.pop();

            if (map[i][j] == 1){
                count++;
                continue;
            }

            for (int[] step: DIRS){
                TagI = i + step[0];
                TagJ = j + step[1];
                if (0 <= TagI && TagI < x
                        && 0 <= TagJ && TagJ < y){
                    stack.push(TagJ);
                    stack.push(TagI);
                }
            }
        }


        return count;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            Robot02 robot = new Robot02();
            String str = in.nextLine();
            String[] subString = str.split(",");
            int x = Integer.parseInt(subString[0]);
            int y = Integer.parseInt(subString[1]);
            int result = robot.countWays(x, y);
            System.out.println("返回: " + result);
        }
    }
}

package demo0003;

import java.util.Scanner;

/**
 * 问题描述:二货小易有一个W*H的网格盒子,网格的行编号为
 * 0~H-1,网格的列编号为0~W-1.每个格子至多可以放一块蛋
 * 糕,任意两块蛋糕的欧几里得距离不能等于2.对于两个格子
 * 坐标(x1,y1),(x2,y2)的欧几里得距离为:((x1-x2)*(x1-x2)
 * +(y1-y2)*(y1-y2))的算数平方根,小易最多可以放多少块蛋糕
 *
 * 输入描述:每组数组包含网格长宽W,H,用空格分割(1<=W,H<=1000)
 *
 * 输出描述:输出一个最多可存放的蛋糕数
 *
 * 输入样例:3 2
 *
 * 输出样例:4
 */


public class Main {

    private static final int[][] DIR2 = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}};
    public static int mostCake(int[] nums){
        int W = nums[0];
        int H = nums[1];
        //处理没有盒子的情况
        if (W == 0){
            return 0;
        }
        //处理正常情况
        int[][] box = new int[W][H];
        int count = 0;  //用于统计蛋糕数
        int x = 0;  //某一空格周围距离为2的行
        int y = 0;  //某一空格周围距离为2的列
        int mark = 0;
        for (int i = 0; i < W; i++){
            for (int j = 0; j < H; j++){  //遍历每一个格子
                mark = 0;
                for (int[] dir : DIR2) {  //判定当前格子是否可以放入蛋糕
                    x = i + dir[0];
                    y = j + dir[1];
                    if (x >= 0 && x < W
                            && y >= 0 && y < H) {
                        if(box[x][y] == 0){
                            mark++;
                        }
                    }else{
                        mark++;
                    }
                }
                if (mark == 4){
                    box[i][j] = 1;
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] nums = new int[2];
        int i = 0;
        while (in.hasNext()){
            String str = in.nextLine();
            String[] strs = str.split(" ");
            for (String num : strs){
                nums[i++] = Integer.parseInt(num);
            }
            int result = mostCake(nums);
            System.out.println(result);
            i = 0;
        }
    }

}

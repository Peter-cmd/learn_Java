package demo003;

import java.util.Scanner;

/**
 问题描述: 学奥巴马画正方形

 输入描述: 输入在一行中给出正方形边长N(3<=N<=20) 和组成正方形的某种字符C,
 间隔一个空格.

 输出描述: 输出由给定字符C画出的正方形.但是注意到行间距比列间距大,所以
 为了让结果看上去更像正方形,我们输出的行数实际上是列数的50%(四舍五入取整).

 输入:
 10 a

 输出:
 aaaaaaaaaa
 a        a
 a        a
 a        a
 aaaaaaaaaa
 */
public class DrawSquare {

    public static void drawSquare(int num, String C){
        int row = (int)Math.round((double)num / 2);
        int col = num;
        for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++) {
                    if (i != 0 && i != row - 1) {
                         if (j == 0 || j == col - 1){
                             System.out.print(C);
                         }else{
                             System.out.print(" ");
                         }
                    }else{
                        System.out.print(C);
                    }
                }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            String[] substr = str.split(" ");
            int num = Integer.parseInt(substr[0]);
            String C = substr[1];
            drawSquare(num, C);
        }
    }
}

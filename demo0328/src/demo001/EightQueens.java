package demo001;

import java.util.Scanner;

/**
 * 八皇后问题
 */

public class EightQueens {

    private static int[] array;
    private static int count;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入皇后的个数:");
        int max = in.nextInt();
        //定义一个数组, 数组下标表示行号, 数组元素表示列好
        //即用一个一位数组表示一个二维数组
        //array[0] = 1, 表示第一行第一列
        EightQueens.array = new int[max];
        check(0, max);
        System.out.println(count);
    }

    private static void check(int n, int max){
        //若所有棋子都已无冲突放入,打印结果
        if (n == max){
            count++;
            display();
            return;
        }

        for (int i = 0; i < max; i++){
            //把当前棋子放入第n行的第i列
            array[n] = i;
            //若不冲突
            if (judge(n)){
                check(n + 1, max);  //继续放入下一个棋子
            }
            //若冲突,考虑将棋子放入下一个位置,
            //若所有位置都冲突,回溯到放入上一颗棋子的状态,
            //调整该棋子的位置,再放入之后的棋子.
        }
    }


    /**
     *
     * @param n 表示第n个皇后,也表示第n行
     * @return
     */
    private static boolean judge(int n){
        //判断当前放入棋子的位置是否与之前已放入的棋子发生冲突
        //既不在同列,也不在同一斜线上
        for (int i = 0; i < n; i++){
            //Math.abs(n - i) 表示两枚棋子之间的行间距,
            //Math.abs(array[n] - array[i]) 表示两枚棋子之间的列间距,
            if (array[i] == array[n]
                    || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;  //发生冲突,返回false
            }
        }
        return true;
    }

    private static void display(){
        int length = array.length;
        for (int i = 0; i < length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

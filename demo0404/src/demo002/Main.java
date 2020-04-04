package demo002;



import java.util.Scanner;

/**
 * 问题描述:给定一个有n个正整数的数组A和一个
 * 整数sum,求选择数组A中部分数字和为sum的方
 * 案数.
 * 当两种选取方案有一个数字的下标不一样,我们就
 * 认为是不同的组成方案.
 *
 *
 * 输入描述:
 * 输入为两行:
 * 第一行为两个正整数n(1<=n<=1000),
 * sum(1<=sum<=1000)
 * 第二行为n个正整数A[i](32位整数),以空格隔开.
 *
 * 输出描述:
 * 输出所求的方案数
 *
 * 输入:
 * 5 15 5 5 10 2 3
 * 输出:
 * 4
 */

public class Main {

    //main方法, 主要负责数的输入
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            //从键盘录入一组数据
            String line = in.nextLine();
            //将数据通过空格分割
            String[] subLine = line.split(" ");
            //获取数组的长度
            int length = Integer.parseInt(subLine[0]);
            //获取要求的数字和
            int sum = Integer.parseInt(subLine[1]);
            //创建一个数组,用以存储数据
            int[] nums = new int[length];
            //遍历数组将 String 类型的数据转为 int 型
            for (int i = 0; i < length; i++){
                nums[i] = Integer.parseInt(subLine[i + 2]);
            }

            int result = count(length, sum, nums);
            System.out.println(result);
        }


    }

    private static int count(int length, int sum, int[] nums) {
        int[][] array = new int[length + 1][sum + 1];

        for (int i = 0; i <= length; i++){
            array[i][0] = 1;
        }

        for (int j = 1; j <= sum; j++){
            array[0][j] = 0;
        }

        for (int i = 1; i <= length; i++){
            for (int j = 0; j <= sum; j++){
                if (nums[i - 1] <= j){
                    array[i][j] = array[i - 1][j] + array[i - 1][j - nums[i - 1]];
                }else{
                    array[i][j] = array[i - 1][j];
                }
            }
        }
        return array[length][sum];
    }
}
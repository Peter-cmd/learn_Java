package demo0004;

import java.util.Scanner;

/**
 * 问题描述: 输入n个整数,输出出现次数大于等于数组长度一半的数
 *
 * 输入描述: n 个空格分隔的 n 个整数, n 不超过100
 *
 * 输出描述: 输出出现次数大于等于 n/2 的数
 *
 * 输入样例:3 9 3 2 5 6 7 3 2 3 3 3
 *
 * 输出样例:3
 */

public class Main {

    public static int findTheNum(int[] array, int n){
        int length = array.length;  //获取字符串长度
        int halfOfN = n / 2;  //数组长度的一半
        //新建一个与arrays等长的数组arrays1
        int[] array1 = new int[length];
        //循环遍历array,统计相同数字出现次数
        for (int i = 0; i < n; i++){
            //利用array中的数字作为array1的下标,对应下标的内容就是该数字出现的次数
            array1[array[i]]++;
        }


        //循环遍历array1,查找出现次数大于等于 halfOfN的数
        int j = 0;
        for (; j < length; j++){
            if (array1[j] >= halfOfN){
                break;
            }
        }
        return j;
    }

    //3 4 5 6 3 3 3 3 3
    //6

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] array = new int[101];
        int i = 0;
        while(in.hasNext()){
            String nums = in.nextLine();
            String[] nums1 = nums.split(" ");
            for (String num : nums1){
                array[i++] = Integer.parseInt(num);
            }
            int result = findTheNum(array, i);
            System.out.println(result);
            i = 0;
        }
    }
}

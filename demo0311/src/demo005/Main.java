package demo005;

import java.util.Scanner;

/**
 * 问题描述: 输入一个整数,将这个整数以字符串的形式逆序输出
 * 不考虑负数情况,若数字含有0,则逆序形式也含有0,输入为100,输出为001.
 *
 * 输入样例:1516000
 *
 * 输出样例:0006151
 *
 */

public class Main {

    private static String reverseStr(String str){
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right){
            char temp = chars[right];
            chars[right] = chars[left];
            chars[left] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            String result = reverseStr(str);
            System.out.println(result);

        }
    }
}

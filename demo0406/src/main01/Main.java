package main01;

import java.util.Scanner;



/**
 * 问题描述: 给定一句英语,要求你编写,将句中的所有单词
 * 的顺序颠倒输出.
 *
 *
 * 输入描述:
 * 测试输入包含一个测试用例,在一行内给出总长度不超过80
 * 的字符串.字符串由若干单词和若干空格组成,其中单词是由
 * 英文字母(大小写有区分)组成的字符串,单词之间用1个空格
 * 分开,输入保证句子末尾没有多余的空格.
 *
 *
 * 输出描述:
 * 每个测试用例的输出占一行,输出倒序后的句子.
 *
 *
 * 输入:
 * Hello World Here I Come
 *
 * 输出:
 * Come I Here World Hello
 */
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            reverse(input);
        }
    }

    public static void reverse(String input){
        //1.将 input 进行分割,分割符为空格
        String[] strs = input.split(" ");
        //2.获取分割后的数组长度
        int length = strs.length;
        //3.假设有两个指针 left 和 right,
        // 两指针同时从数组两端向中间依次遍历,
        // 交换两指针指向的内容,直到两指针相遇.
        int left = 0;
        int right = length - 1;
        while (left < right){
            swap(strs, left, right);
            left++;
            right--;
        }

        //4.将逆置后的数组拼接成新的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++){
            if (i != length - 1){
                stringBuilder.append(strs[i] + " ");
            }else{
                stringBuilder.append(strs[i]);
            }
        }
        //5.打印结果
        System.out.println(stringBuilder);
    }

    //交换 left 和 right 下标的内容
    private static void swap(String[] strs, int left, int right) {
        String temp = strs[left];
        strs[left] = strs[right];
        strs[right] = temp;
    }


}

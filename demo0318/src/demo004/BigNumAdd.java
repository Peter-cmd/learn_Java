package demo004;

import java.math.BigInteger;
import java.util.Scanner;

/**
 问题描述: 请设计一个算法完成两个超长正整数的加法
 输入参数:
 String addend : 加数
 String augend : 被加数
 返回值 : 加法结果

 输入描述:
 输入两个字符串数字

 输出描述:
 输出相加后的结果, string型

 输入
 99999999999999999999999999999999999999999999999999
 1
 100000000000000000000000000000000000000000000000000
 */
public class BigNumAdd {
    public static String addLongInteger(String addend, String augend){
        BigInteger a = new BigInteger(addend);
        BigInteger b = new BigInteger(augend);
        return a.add(b).toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String addend = in.nextLine();
            String augend = in.nextLine();
            String result = addLongInteger(addend, augend);
            System.out.println(result);
        }
    }
}

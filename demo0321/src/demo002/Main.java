package demo002;

import java.util.Scanner;

/**
 问题描述: 一个DNA序列由A/C/G/T四个字母的排列组合组成.G和C的比例(定义为GC-Ratio)
 是序列中G和C两个字母的总的出现次数除以总的字母数目(也就是序列长度).在基因工程中,这个
 比例非常重要.因为高的GC-Ratio可能是基因的起始点.
 给定一个很长的DNA序列,以及要求的最小子序列长度,研究人员需要在其中找出GC-Ratio最高的
 子序列.


 输入描述:输入一个string型基因序列,和int型子串的长度

 输出描述:找出GC比例最高的子串,如果有多个输出第一个的子串

 输入:
 AACTGTGCACGACCTGA
 5
 输出:
 GCACG
 */
public class Main {

    public static String highestRatioSubstring(String DNA, int n){
        char[] basicGroup = DNA.toCharArray();
        int count = 0;  //统计子串中G和C的出现次数
        double max = 0.0;  //记录最大的GC-Ration
        int length = basicGroup.length;  //获取基因序列长度
        double[] temp = new double[length];  //记录每条子序列对应的GC-Ratio
        for (int i = 0; i < length - n; i++){  //遍历基因序列
            count = 0;  //count置零,开始一条新的子序列
            for (int j = i; j < i + n; j++){  //编历一条长度为 n 的子序列
                if (basicGroup[j] == 'C' || basicGroup[j] == 'G'){  //若碱基为 G 或 C, count 加 1
                    count++;
                }
            }
            temp[i] = (double)count / length;  //记录 [i, i+n) 位置的子序列的GC-Ratio
            if (temp[i] > max){  //更新最大的GC-Ratio
                max = temp[i];
            }
        }

        for (int i = 0; i < length; i++){
            if (temp[i] == max){
                return new String(basicGroup, i, n);
            }
        }
        return null;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String DNA = in.nextLine();
            int length = Integer.parseInt(in.nextLine());
            String result = highestRatioSubstring(DNA,length);
            System.out.println(result);
        }
    }
}

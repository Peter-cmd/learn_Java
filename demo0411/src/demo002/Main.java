package demo002;

import java.time.chrono.MinguoChronology;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 问题描述:
 * On a broken keyboard, some of the keys are
 * worn out. So when you type some sentences,
 * the characters
 * corresponding to those keys will not appear
 * on screen.
 *
 * Now given a string that you are supposed to
 * type , and the string that you actually type
 * out, please list those keys which are for sure
 * worn out.
 *
 * 输入描述:
 * Each input file contains one test case. for each
 * case, the 1st line contains the original string,
 * and the 2nd line contains the typed-out string.
 * Each string contains no more than 80 characters
 * which are either English letters [A-Z]
 * (case insensitive), digital numbers [0-9], or "_"
 * (representing the space). It is guaranteed that
 * both strings are non_empty.
 *
 *
 * 输出描述:
 * For each test case, print in one line the keys that
 * are worn out,in the order of being detected. The English
 * letters must be capitalized.
 * Each worn out key must be printed once only.
 * It is guaranteed that there is at least one worn out key.
 *
 * 输入:
 * 7_This_is_a_test
 * _hs_s_a_es
 *
 * 输出:
 * 7TI
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            //记录输入字符串
            String type = in.next();
            type = type.toUpperCase();
            //记录输出字符串
            String output = in.next();
            output = output.toUpperCase();
            findWornKey(type, output);

        }
    }

    private static void findWornKey(String type, String output) {
        char[] type1 = type.toCharArray();
        Set<Character> output1 = new HashSet<>();
        Set<Character> printed = new HashSet<>();
        StringBuilder stb = new StringBuilder();
        //分别获取两字符串的长度
        int length1 = type.length();
        int length2 = output.length();
        //将字符串转换成字符存入 set 集合,达到去重的目的

        for (int i = 0; i < length2; i++){
            char temp = output.charAt(i);
            output1.add(temp);
        }

        //遍历集合 type1,并判断 output1 中是否包含该元素
        for (int i = 0; i < length1; i++){
            //若集合 output1 中不包含 type1 的当前元素,则
            //type1 的当前元素为 worn_key
            char ch = type1[i];
            if (!output1.contains(ch) && !printed.contains(ch)){
                    stb.append(ch);
                    printed.add(ch);
                    
            }
        }
        System.out.println(stb.toString());
    }
}

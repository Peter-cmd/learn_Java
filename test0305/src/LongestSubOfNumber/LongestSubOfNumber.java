package LongestSubOfNumber;
/**
 * 问题描述:读入一个字符串str,输出字符串str中最长的连续子串
 *
 * 输入: abcd1234ed125ss123456789
 *
 * 输出: 123456789
 */
import java.util.Scanner;
public class LongestSubOfNumber {

    //找一个字符串的最长连续子串
    public static String findLongest(String str, int length) {

        //若字符串长度为0,直接返回
        if (length == 0) {
            return "";
        }

        //将将字符串转化为数组
        char[] chars = str.toCharArray();

        int left = 0;  //字符串左边界

        int maxLength = 0;  //最大连续数字字符串长度
        int maxLeft = 0;  //最大连续数字字符串左边界
        int maxRight = 0;  //最大连续数字字符串右边界
        int leftTag = 0;  //标记连续数字字符串开始位置下标

        while (left < length) {
            if (chars[left] >= '0'
                    && chars[left] <= '9') {  //若是数字
                //若字符串第一个字符为数字
                if (leftTag == 0 && left == 0) {
                    leftTag = left;  //记录连续数字字符串开始位置
                    left++;
                    continue;
                }

                //标记一个新的连续数字串开始的位置
                //通过判断其前一个字符是否是数字决定是否更新标记
                if (chars[left - 1] < '0'
                        || chars[left - 1] > '9') {
                    leftTag = left;  //记录连续数字字符串开始位置
                }

                left++;  //left向后移

                if (left - leftTag > maxLength) {  //求当前连续数字字符串的长度并与之前保存的长度比较
                    //记录当前连续字符串长度, 左边界和右边界
                    maxLength = left - leftTag;
                    maxLeft = leftTag;
                    maxRight = left;  //有效字符串为 [maxLeft,maxRight)
                }
            }else{
                left++;
            }
        }

        return str.substring(maxLeft, maxRight);
    }


        public static void main (String[] args){
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {  //循环接收字符串
                String str = in.next();
                int length = str.length();  //求字符串的长度
                System.out.println(findLongest(str, length));

            }
        }
    }

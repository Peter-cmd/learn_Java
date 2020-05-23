package demo002;

import java.util.ArrayList;
import java.util.Arrays;



public class Solution {
    public static ArrayList<String> Permutation(String str) {

        //返回结果,用以保存所有排列结果
        ArrayList<String> result = new ArrayList<>();
        //将字符串转化为字符数组
        char[] chars = str.toCharArray();
        int length = chars.length;
        Arrays.sort(chars);
        //创建一个 StringBuilder 对象,负责将字符数组转成 String 对象
        StringBuilder stringBuilder = new StringBuilder();
        //获取执行次数
        int n = 1;
        for (int i = 1; i <= length; i++){
            n *= i;
        }
        //将字符数组加入 stringBuilder
        stringBuilder.append(chars);
        //将 stringBuilder 中的内容转化成 String 类型,并将结果加入 result
        result.add(stringBuilder.toString());
        //清理 stringBuilder 的内容
        stringBuilder.delete(0, stringBuilder.length());
        n--;
        int mark = 0;
        while (n > 0){
            //从左向右找第一个左边小于右边的数,记录其下标
            for (int i = length - 1; i > 0; i--){
                //若找到左边比右边小的数
                if (chars[i] > chars[i - 1]){
                    mark = i - 1;
                    break;
                }
            }


            //再次从左向右找第一个右边比以 mark 为下标的元素大的数,记录其下标
            for (int i = length - 1; i > mark; i--){
                if (chars[i] > chars[mark]){
                    swap(chars, i, mark);
                    break;
                }
            }

            //将下标在 mark 之后的元素进行排序
            sort(chars, mark + 1, length - 1);
            //将字符数组加入 stringBuilder
            stringBuilder.append(chars);
            //将 stringBuilder 中的内容转化成 String 类型,并将结果加入 result
            result.add(stringBuilder.toString());
            //清理 stringBuilder 的内容
            stringBuilder.delete(0, stringBuilder.length());
            n--;
        }

        return result;
    }

    //交换两个下标的元素
    private static void swap(char[] chars, int point, int mark) {
        char temp = chars[point];
        chars[point] = chars[mark];
        chars[mark] = temp;
    }

    //将数组中指定区间的元素进行排序
    public static void sort(char[] chars, int start, int end){
        if (start >= end){
            return;
        }

        int pivotIndex = partition(chars, start, end);
        sort(chars, start, pivotIndex - 1);
        sort(chars, pivotIndex + 1, end);
    }

    private static int partition(char[] chars, int start, int end) {
        int left = start;
        int right = end;

        while (left < right){
            while (left < right && chars[right] >= chars[start]){
                right--;
            }

            while (left < right && chars[left] <= chars[start]){
                left++;
            }
            swap(chars, left, right);
        }

        swap(chars, left, start);
        return left;
    }


    public static void main(String[] args){
        String str = "acbg";
        Permutation(str);
    }
}

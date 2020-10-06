package longest;

import java.util.*;


public class Solution {
    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {

        // write code here
        // 保存 arr 中数字的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;  // 记录目前为止重复出现数字中最大的下标
        int j = 0;  // 记录当前数字的下标
        int result = Integer.MIN_VALUE;  // 记录最长的无重复子串的长度
        int length = arr.length;  // 记录 arr 数组的长度
        // 若 j 小于 length
        while(j < length){
            // 若当前数字第一次出现
            if (!map.containsKey(arr[j])){
                // 将当前数字的下标加 1, 加入 map
                map.put(arr[j], j + 1);
            }else {  // 若当前数字重复出现,记录目前为止重复出现数字中最大的下标
                i = Math.max(i, map.get(arr[j]));
                // 将当前数字的下标加 1, 加入 map
                map.put(arr[j], j + 1);
            }
            // 更新最长的无重复子串的长度
            result = Math.max(result, j - i + 1);
            // 遍历数组中的下一个数字
            j++;
        }
        return result;
    }

    public static void main(String[] args){}
}

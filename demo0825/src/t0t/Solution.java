package t0t;

import java.util.ArrayList;
class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 处理数组为空和数组长度为 0 的情况
        if (nums == null || nums.length == 0){
            return new int[0];
        }

        // 获取数组元素个数
        int length = nums.length;
        // 按 num 中元素进入 da 的先后顺序,来保存其下标
        int[] id = new int[length + 1];
        // 存储有效元素
        int[] da = new int[length + 1];
        // 保存最后的结果
        int[] result = new int[length - k + 1];
        // 判断插入当前元素前, da 中是否还有有效元素
        int ls = 1;
        int re = 0;

        // 模拟华东窗口后移的操作
        for (int i = 0, j = 0; i < length; i++){

            // 剔除 da 中所有小于 nums【i】 的元素
            while (ls <= re && nums[i] > da[re]) re--;
            // 将 nums【i】放入 da 中,并保存其下标.
            re++;
            da[re] = nums[i];
            id[re] = i;

            // 剔除 id 中与当前 i 距离大于等于 k 的节点
            if (id[ls] + k <= i) ls++;
            // 若当前 i 大于等于 k - 1, 即已存在满足 k 个元素的滑动窗口,保存结果.
            // 注意： k 是从 1 开始， i 是从 0 开始
            if (i >= k - 1) result[j++] = da[ls];


        }
        return result;
    }


    public static void main(String[] args){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow(nums, k);
    }

}

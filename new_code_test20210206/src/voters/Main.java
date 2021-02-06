package voters;

/**
 * 问题描述: 现有一个数组, 其中有一个数出现的次数大于数组长度的一半,
 *    请找出该数.
 */

class Solution {
    // 找出现次数最多的数, 也就是找到该数组元素的众数
    public int majorityElement(int[] nums) {
        // 票数
        int vote = 0;
        // 候选人
        int voter = 0;
        // 遍历数组根据数组元素进行投票(若当前元素与候选人一致, 则票数加1; 反之, 减1)
        for (int i = 0; i < nums.length; i++) {
            // 若当前计票为0, 更换候选人
            if (vote == 0) {
                voter = nums[i];
            }
            // 若当前元素与候选人一致, 则票数加1
            if (voter == nums[i]) {
                vote++;
            }else{  // 若当前元素与候选人不一致, 则票数减1
                vote--;
            }
        }
        return voter;
    }
}
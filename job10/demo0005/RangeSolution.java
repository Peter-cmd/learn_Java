package job10.demo0005;

public class RangeSolution {
    public int[] searchRange(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){  //遍历数组
            if (left < right && nums[left] != target){  //找左边的target下标
                left++;
            }
            if (left < right && nums[right] != target){  //找右边的target下标
                right--;
            }
            if (nums[left] == target && nums[right] == target){  //若找到,且left < right返回
                return new int[]{left, right};
            }
        }
        if (left == right && nums[left] == target){  //若找到,且left = right = target返回
            return new int[]{left, right};
        }
        return new int[]{-1, -1};  //未找到
    }
}

package job01.demo0003;

public class Solution {

    //翻转交换数组的元素
    private static void reverse(int[] num, int start, int end){
        while(start < end){
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
    }

    //数组元素向右移动k步
    public void rotate(int[] nums, int k){
        if (k <= 0){
            return;
        }
        k %= nums.length;  //若向右移动的步数大于数组长度,取余
        reverse(nums, 0, nums.length - 1);  //翻转整个数组
        reverse(nums, 0, k - 1);  //翻转数组0 到 k - 1 的部分
        reverse(nums, k, nums.length - 1);  //翻转数组k 到 数组最后一个元素的部分
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        solution.rotate(nums, k);
        System.out.print("{");
        for (int i = 0; i < nums.length; i++){
            if (i == nums.length - 1){
                System.out.println(nums[i] + "}");
                continue;
            }
            System.out.print(nums[i] + ", ");
        }

    }
}

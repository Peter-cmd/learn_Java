package job02.demo0001;

import java.util.Scanner;

public class Solution {
    public int removeElement(int[] nums, int val){
        int count = 0;
        int i = 0;
        while (i < nums.length){
            if (nums[i] == val){
                i++;
                continue;
            }
            nums[count++] = nums[i];
            i++;
        }
        return count;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] array = {1, 5, 2, 3, 4, 5, 5, 6};
        int val = 5;
        int count = solution.removeElement(array, val);
        System.out.println(count);
        int i = 0;
        while (i < count){
            System.out.print(array[i] + " ");
            i++;
        }
    }
}

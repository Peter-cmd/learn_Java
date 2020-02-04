package job06.demo0002;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int[] nums = new int[m + n];
        int i = 0;
        int j = 0;
        int index = 0;
        while(i < m && j < n){
            if (nums1[i] < nums2[j]){
                nums[index] = nums1[i];
                index++;
                i++;
            }else{
                nums[index] = nums2[j];
                index++;
                j++;
            }
        }

        while(i < m){
            nums[index] = nums1[i];
            index++;
            i++;
        }

        while(j < n){
            nums[index] = nums2[j];
            index++;
            j++;
        }

        index = 0;
        while (index < (m + n)){
            nums1[index] = nums[index];
            index++;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 4, 5};
        solution.merge(nums1, 3, nums2, 3);
        for (int i = 0; i < 6; i++){
            System.out.println(nums1[i]);
        }
    }
}

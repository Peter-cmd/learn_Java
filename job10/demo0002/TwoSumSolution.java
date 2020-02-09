package job10.demo0002;
import java.util.Map;
import java.util.HashMap;
public class TwoSumSolution{
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int[] array = new int[2];
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                array[0] = i;
                array[1] = map.get(complement);
            }
        }
        return array;
    }

    public static void main(String[] args){
        int[] nums = {3, 3};
        int target = 6;
        int[] array = TwoSumSolution.twoSum(nums, target);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}

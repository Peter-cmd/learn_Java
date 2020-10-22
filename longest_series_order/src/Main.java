import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    private static int longestConsecutive(int[] nums){
        // 若数组为空
        if (nums == null || nums.length == 0){
            return 0;
        }

        int max = 1;
        Map<Integer, Integer>  map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], 1);

                if (map.containsKey(nums[i] - 1)){
                    max = Math.max(max, merge(map, nums[i] - 1, nums[i]));
                }

                if (map.containsKey(nums[i] + 1)){
                    max = Math.max(max, merge(map, nums[i], nums[i + 1]));
                }

            }
        }
        return max;

    }


    private static int merge(Map<Integer, Integer> map, int less, int more){
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(less, len);
        map.put(more, len);
        return len;
    }

    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();

            int[] array = new int[n];

            for (int i = 0; i < n; i++){
                array[i] = in.nextInt();
            }

            int result = longestConsecutive(array);
            System.out.println(result);
        }
    }
}

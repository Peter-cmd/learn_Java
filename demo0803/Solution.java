package t02;
import java.util.*;

public class Solution {

    private static void halfCount(int n, int[] nums) {
        int half = n / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > half) {
                System.out.println(entry.getKey());
                return;
            }
        }
        System.out.println("-1");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        while (in.hasNext()) {
            int n = Integer.parseInt(in.next());
            int[] nums = new int[n];
            while (i < n) {
                nums[i] = Integer.parseInt(in.next());
                i++;
            }
            halfCount(n, nums);
            i = 0;
        }
        in.close();
    }
}
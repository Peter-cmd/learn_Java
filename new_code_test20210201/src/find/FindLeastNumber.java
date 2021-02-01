package find;

import java.util.Scanner;

public class FindLeastNumber {

    private static String findLeastNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int length = nums.length;
        int index0 = 0;
        for (int i = 0; i < length; i++) {

            for (int j = 0; j < nums[i]; j++) {
                sb.append(i);
                if (index0 == 0 && nums[i] != 0 && i != 0) {
                    index0 = i;
                    sb.reverse();
                }
            }

        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[10];
        while (in.hasNext()) {
            for (int i = 0; i < 10; i++) {
                nums[i] = Integer.parseInt(in.next());
            }
            String result = findLeastNumber(nums);
            System.out.println(result);
        }
    }
}
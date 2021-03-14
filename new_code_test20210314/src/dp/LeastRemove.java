package dp;

import java.util.ArrayList;
import java.util.Scanner;

public class LeastRemove {

    public static int findLeastRemove(String input) {
        int length = input.length();
        int dp[] = new int[1 << length];

        for (int t = 1; t < dp.length; t++) {
            dp[t] = isPalindrome(t, input) ? 1 : Integer.MAX_VALUE;
            for (int i = t; i != 0; i = (i - 1) & t) {
                dp[t] = Math.min(dp[t], dp[i] + dp[i ^ t]);
            }
        }
        return dp[(1 << length) - 1];
    }


    public static boolean isPalindrome(int bitMap, String input) {
        ArrayList<Character> sequence = new ArrayList<>();
        int i = 0;
        while (i < 32) {
            if ((bitMap & (1 << i)) != 0) {
                sequence.add(input.charAt(i));
            }
            i++;
        }
        int left;
        int right;
        for (left = 0, right = sequence.size() - 1; left < right; left++, right--) {
            if (sequence.get(left) != sequence.get(right)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String input = in.nextLine();
            int result = findLeastRemove(input);
            System.out.println(result);
        }
    }
}

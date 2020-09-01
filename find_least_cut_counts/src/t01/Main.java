package t01;

import java.util.Scanner;
public class Main{

    private static void findLeastCutCounts(String input){
        char[] chars = input.toCharArray();
        int length = chars.length;
        // dp1[i][j] 表示字符串 i 到 j 的子串是回文串
        boolean[][] dp1 = new boolean[length][length];
        for (int i = length - 1; i >= 0; i--){
            for (int j = i; j < length; j++){
                // 若 input.charAt(i) == input.charAt(j):

                // 若 i == j, dp1[i][j] = true;
                if (i == j) dp1[i][j] = true;
                // 若 i + 1 == j, dp1[i][j] = true;
                if (i + 1 == j) dp1[i][j] = (chars[i] == chars[j]);
                // 若 j - i > 1, dp1[i][j] = dp1[i + 1][j - 1];
                if (j - i > 1) dp1[i][j] = (chars[i] == chars[j]) && dp1[i + 1][j -1];
            }
        }

        // dp2[i] 保存 i 个字符的最小切割数
        int[] dp2 = new int[length + 1];
        // dp2[i] = min(dp2[i], dp2[j] + 1) && dp1[j][i - 1]
        // 初始化 : dp2[i] = i - 1
        for (int i = 0; i <= length; i++){
            dp2[i] = i - 1;
        }

        for (int i = 1; i <= length; i++){
            for (int j = i - 1; j >= 0; j--){
                if (dp1[j][i - 1]){
                    dp2[i] = Math.min(dp2[i], dp2[j] + 1);
                }
            }
        }
        System.out.println(dp2[length]);

    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String input = in.next();
            findLeastCutCounts(input);
        }
    }
}
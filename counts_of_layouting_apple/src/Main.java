import java.util.Scanner;
public class Main{

    private static void countsOfLayoutingApple(int m, int n){
        // 记录 m 个苹果放入 n 个盘子的方案数
        int dp[][] = new int[m + 1][n + 1];
        // 若盘子只有一个则只有 1 种方案
        for (int j = 1; j <= n; j++){
            dp[0][j] = 1;
        }
        // 一次考虑将 i 个苹果放入 j 个盘子的方案数
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                // 若苹果数小于盘子数,则考虑将 i 个苹果放入 i 个盘子
                if (i < j){
                    dp[i][j] = dp[i][i];
                }else{  // 若苹果数大于等于盘子数,则考虑将 i - j 个
                    //苹果放入 j 个盘子和 i 个苹果放入 j - 1 个盘子的方案和
                    dp[i][j] = dp[i - j][j] + dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[m][n]);
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            countsOfLayoutingApple(m, n);
        }
    }
}
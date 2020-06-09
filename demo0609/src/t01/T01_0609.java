package t01;

public class T01_0609 {
    public static void main(String[] args){
        int n = 3;
        int m = 3;
        int[] x = {2,3,2};
        int[] y = {3,2,1};
        int result = solve(n, m, x, y);
        System.out.println(result);

    }

    public static int solve (int n, int m, int[] x, int[] y) {
        // write code here
        //定义f(i,j)表示(1,1)到(i,j)的路径数
        //若i = 1, 0 < j <= n, f(i,j) = f(i, j-1) + f(i+1, j-1);
        //若i = 3, 0 < j <= n, f(i,j) = f(i, j-1) + f(i-1, j-1);
        //若1 < i < 3, 0 < j <= n,
        //f(i,j) = f(i, j-1) + f(i+1, j-1) + f(i-1, j-1)
        int[][] dp = new int[4][n+1];
        //设置障碍
        for (int i = 0; i < x.length; i++){
            dp[x[i]][y[i]] = -1;
        }
        dp[1][1] = 1;
        for (int j = 1; j <= n; j++){
            if (dp[1][j] != -1){
                dp[1][j] += dp[1][j-1] != -1 ? dp[1][j-1] : 0;
                dp[1][j] %= 1000000007;
                dp[1][j] += dp[2][j-1] != -1 ? dp[2][j-1] : 0;
                dp[1][j] %= 1000000007;
            }
            if (dp[2][j] != -1){
                dp[2][j] += dp[1][j-1] != -1 ? dp[1][j-1] : 0;
                dp[2][j] %= 1000000007;
                dp[2][j] += dp[2][j-1] != -1 ? dp[2][j-1] : 0;
                dp[2][j] %= 1000000007;
                dp[2][j] += dp[3][j-1] != -1 ? dp[3][j-1] : 0;
                dp[2][j] %= 1000000007;
            }
            if (dp[3][j] != -1){
                dp[3][j] += dp[3][j-1] != -1 ? dp[3][j-1] : 0;
                dp[3][j] %= 1000000007;
                dp[3][j] += dp[2][j-1] != -1 ? dp[2][j-1] : 0;
                dp[3][j] %= 1000000007;
            }
        }

        return dp[3][n];
    }

}

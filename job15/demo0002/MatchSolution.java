package job15.demo0002;

public class MatchSolution {
    //状态: dp[i][j] 表示 S 的前 i 个字符与 P 的前 j 个字符匹配成功
    //状态转移:
    //如果 S[i] = P[j] 或 P[j] = "?", 那么 dp[i][j] = dp[i - 1][j - 1];
    //如果 P[j] = "*", 那么 dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
    //dp[i][j - 1] 表示 "*" 匹配的是 S 中的空字符, S : ab   P : ab*
    //dp[i - 1][j] 表示 "*" 匹配的是 S 中的有效字符. S : abcd  P : ab*    ?
    //初始化:
    // dp[0][0] 表示 S 和 P 都为空, 为true
    // dp[0][j] 表示 S 为空, 当且仅当 P 全为 "*" 表示时为 true;
    // dp[i][0] 表示 P 为空, 全为false
    public static boolean isMatch(String S, String P){
        int m = S.length();  //获取 S 的长度
        int n = P.length();  //获取 P 的长度
        //用以保存字符匹配状态
        boolean[][] dp = new boolean[m + 1][n + 1];

        //初始化
        dp[0][0] = true;
        for (int j = 1; j <= n; j++){
            dp[0][j] = dp[0][j - 1] && (P.charAt(j - 1) == '*');
        }

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (S.charAt(i - 1) == P.charAt(j - 1)
                        || P.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (P.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        String S = "aac";
        String P = "aa*";
        boolean result = MatchSolution.isMatch(S, P);
        System.out.println(result);

    }
}

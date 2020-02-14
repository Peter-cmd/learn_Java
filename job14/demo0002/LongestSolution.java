package job14.demo0002;
import java.util.Arrays;
public class LongestSolution {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int m, n;

    public static int longestIncreasingPath(int[][] matrix){
        m = matrix.length;
        //处理数组为空的情况
        if (m == 0){
            return 0;
        }

        //处理一般情况
        int ans = 0;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                ans = Math.max(ans, dfs(matrix, i, j, cache));
            }
        }
        return ans;
    }

    //深度优先遍历
    public static int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0){
            return cache[i][j];
        }
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (0 <= x && x < m
                    && 0 <= y && y < n
                    && matrix[i][j] < matrix[x][y]) {
                 cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
            }
        }
        return ++cache[i][j];
    }

    public static void main(String[] args){
        int[][] matrix = {{9,9,4,3,4,5,5,6}, {6,6,8,4,5,6,6,5}, {2,1,1,5,5,6,5,6}};
        int ans = LongestSolution.longestIncreasingPath(matrix);
        System.out.println(ans);
    }
}

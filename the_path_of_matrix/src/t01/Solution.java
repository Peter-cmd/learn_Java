package t01;

class Solution {
    private static final int[][] DIRS = {{-1, 0},
            {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        // 若字符串为空
        if ("".equals(word)){
            return true;
        }
        int r = board.length;
        int c = board[0].length;
        boolean result = false;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (board[i][j] == word.charAt(0)){
                    result = dfs(board, word, 0, i, j, r, c);
                    if (result){
                        return result;
                    }
                }
            }
        }
        return result;
    }

    private static boolean dfs(char[][] board, String word, int n, int i, int j, int r, int c){
        // 若找到符合要求的字符串,则返回 true
        if (n == word.length() - 1){
            return true;
        }

        if (board[i][j] == '1'){
            return false;
        }


        // 标记做走过的路径
        char tempParent = board[i][j];
        board[i][j] = '1';
        int newI = 0;
        int newJ = 0;
        boolean result = false;
        for (int[] dir : DIRS){
            newI = i;
            newJ = j;
            newI += dir[0];
            newJ += dir[1];
            if (newI >= 0 && newI < r && newJ >= 0 && newJ < c
                    && board[newI][newJ] == word.charAt(n + 1)){
                result = dfs(board, word, n + 1, newI, newJ, r, c);
            }

            if (result){
                board[i][j] = tempParent;
                return result;
            }
        }
        board[i][j] = tempParent;
        return result;
    }
}
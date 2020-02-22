package job0222;

public class IslandSolution {
    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        int r = grid.length;
        if (r == 0){
            return count;
        }
        int c = grid[0].length;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (grid[i][j] == '1'){
                    bfs(grid, i, j, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    public static void bfs(char[][] grid, int i, int j, int r, int c){
        int x = 0;
        int y = 0;
        for (int[] dir : dirs){
            x = i + dir[0];
            y = j + dir[1];
            if (0 <= x && x < r
                    && 0 <= y && y < c
                    && grid[x][y] == '1'){
                grid[x][y] = '0';
                bfs(grid, x , y, r, c);
            }
        }
    }

    public static void main(String[] args){
        char[][] grid = {{'1', '1', '1', '0'},
                         {'1', '1', '0', '0'},
                         {'0', '0', '1', '1'},
                         {'1', '0', '0', '1'}};
        IslandSolution solution = new IslandSolution();
        int count = solution.numIslands(grid);
        System.out.println(count);
    }
}

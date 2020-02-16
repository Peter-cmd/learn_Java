package job15.demo0003;


public class Test02 {
    public static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[0].length == 0) {
            return image;
        }
        int r = image.length;
        int c = image[0].length;
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        dfs(image, sr, sc, r, c, newColor, color);
        return image;
    }

    public static void dfs(int[][] image, int i, int j, int r, int c, int newColor, int color) {
        int x, y;
        for (int[] d : dir) {
            x = i + d[0];
            y = j + d[1];
            if (0 <= x && x < r && 0 <= y && y < c
                    && image[x][y] == color && image[x][y] != newColor) {
                image[x][y] = newColor;
                dfs(image, x, y, r, c, newColor, color);
            }
        }
    }

    public static void main(String[] args){
        int[][] image = {{0,0,0}, {0,1,1}};
        Test02.floodFill(image, 1, 1, 1);
    }
}


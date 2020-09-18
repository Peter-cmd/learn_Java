package t01;

/*
111
110
101

222
220
201

*/

class Solution {
    public static final int[][] dirs = {{-1, 0}, {1, 0}, {0 ,-1}, {0, 1}};  //判定边界
    // 填充方法
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 若图不存在,返回 image
        if (image.length == 0 || image[0].length == 0){
            return image;
        }
        int r = image.length;
        int c = image[0].length;
        // 记录旧的颜色
        int color = image[sr][sc];
        // 将当前位置修改为新的颜色
        image[sr][sc] = newColor;
        // 深度搜索填充图的每一块区域
        dfs(image, sr, sc, r, c, newColor, color);
        return image;
    }

    public static void dfs(int[][] image, int i, int j, int r, int c, int newColor, int color){
        int x, y;
        for(int[] d : dirs){  //向四周扩展
            x = i + d[0];
            y = j + d[1];
            // 若扩展节点等于color,且不等于newcolor
            // 判定边界是否合法
            if (0 <= x && x < r && 0 <= y && y < c && image[x][y] == color && image[x][y] != newColor){
                image[x][y] = newColor;
                dfs(image, x, y, r, c, newColor, color);
            }
        }
    }
}
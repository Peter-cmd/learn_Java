package demo01;

import java.util.List;
import java.util.ArrayList;
class Solution {
    private static List<Integer> ufs = null;

    //初始化并查集
    public static List unionFindSet(int size){
        List list = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            list.add(-1);
        }
        return list;
    }

    //查找并查集中元素的根元素
    public static int findRoot(int index){
        while (ufs.get(index) >= 0){
            index = ufs.get(index);
        }
        return index;
    }

    //将两个元素进行连接
    public static boolean union(int x, int y){
        int rootX = findRoot(x);
        int rootY = findRoot(y);

        //若带连接两元素的父元素相同,即两元素之间有联系
        if (rootX == rootY && rootX != -1 && rootY != -1){
            return false;
        }

        ufs.set(rootX, (ufs.get(rootX) + ufs.get(rootY)));
        ufs.set(rootY, rootX);
        return true;
    }

    //查找岛屿的数量
    public static int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int max = Math.max(r, c);
        int count = 0;
        ufs = unionFindSet(max);
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (grid[i][j] == '1') {
                    union(i, j);
                }
            }
        }
        for (Integer item : ufs){
            if (item < 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

}
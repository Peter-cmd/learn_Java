package t01_0628;
public class Solution {
    private final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int movingCount(int threshold, int rows, int cols){
        //初始条件:创建并初始化地图和可到达格子数变量(初始值为 0),
        int result = 0;
        int[][] map = new int[rows][cols];
        //1.首先确定采用 DFS 进行遍历
        int[] position = new int[2];
        map[0][0] = 1;
        result = dfs(map, position, threshold) + 1;
        return result;

    }

    //深度优先遍历
    private static int dfs(int[][] map, int[] position, int threshold){
        int x = position[0];
        int y = position[1];
        map[x][y] = 1;
        //  b.若格子元素值为 0, 判断当前格子是否可以到达:
        //     1)若可以到达,修改当前格子的元素值为 1, 可到达格子数加 1;
        //     2)若不可以到达,修改当前格子的元素值为 -1;
        //2.每遍历一个格子,根据格子的元素值进行如下判定:
        // a.若格子元素值为 1或-1,跳过本次迭代;
        int result = 0;
        //向四个方向拓展
        for (int i = 0; i < 4; i++){
            int[] dir = DIRS[i];
            position[0] = x + dir[0];
            position[1] = y + dir[1];
            //判定格子下标是否合法
            if (position[0] >= 0 && position[0] < map.length
                    && position[1] >= 0 && position[1] < map[0].length
                    && judge(threshold, position, map)){
                result += dfs(map, position, threshold) + 1;
            }
        }
        return result;
    }

    private static boolean judge(int threshold, int[] position ,int[][] map){
        int sum = 0;
        int temp = 0;
        //若该点已经经过判定
        if (map[position[0]][position[1]] == -1 ||  map[position[0]][position[1]] == 1){
            return false;
        }
        //若该点未经过判定,判定该点坐标是否合法
        for (int i = 0; i < position.length; i++){
            temp = position[i];
            while (temp > 0){
                sum += temp % 10;
                temp /= 10;
            }
        }
        //若该点可达,返回真
        if (sum <= threshold){
            return true;
        }

        //若该点不可达,修改该点的元素值为 -1
        map[position[0]][position[1]] = -1;
        return false;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int result = solution.movingCount(5, 10, 10);
        System.out.println(result);
    }
}
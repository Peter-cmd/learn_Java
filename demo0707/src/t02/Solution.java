package t02;

public class Solution {
    /**
     ABCE
     SFCS
     ADEE


     ABCCED
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        //1.遍历数组的每一个点,从该点开始向左,右,上,下的遍历数组的所有元素,
        //a.若遍历完所有的元素为找到符合要求的字符串,回溯并以下一个点为起点进
        //行上述操作,直至数组所有元素都已被拓展过,结束遍历,返回 false;
        //b.若找到一个满足要求的字符串,返回结果 true;
        // 标记数组的元素是否访问过
        boolean[] visited = new boolean[matrix.length];
        //以数组中的每一个元素为起点找一条符合要求求的路径
        int k = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (judge(matrix, visited, rows, cols, str, i, j, k)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean judge(char[] matrix, boolean[] visited,
                                 int rows, int cols, char[] str, int i, int j, int k){
        int index = i * cols + j;


        //判定边界是否合法,以及当前格子是否访问过
        if (i < 0 || i >= rows || j < 0 || j >= cols ||
                matrix[index] != str[k] || visited[index] == true){
            return false;
        }

        //若找到完全匹配 str 的字符串,返回 true
        if (k == str.length - 1){
            return true;
        }
        boolean result = false;
        //若当前数组元素与目标字符串字符匹配,从当前元素向四周扩展
        if (matrix[index] == str[k]){
            visited[index] = true;
            //向上,下,左,右扩展
            result = judge(matrix, visited, rows, cols, str, i - 1, j, k + 1)
                    || judge(matrix, visited, rows, cols, str, i + 1, j, k + 1)
                    || judge(matrix, visited, rows, cols, str, i, j - 1, k + 1)
                    || judge(matrix, visited, rows, cols, str, i, j + 1, k + 1);
            visited[index] = false;
        }

        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        char[] matrix = {'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S',
                'A', 'D', 'E', 'E'};
        char[] str = {'A', 'B', 'C', 'C', 'E', 'D'};
        solution.hasPath(matrix, 3, 4, str);
    }
}
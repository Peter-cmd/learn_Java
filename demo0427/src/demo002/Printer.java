package demo002;

/**
 * 问题描述:对于一个矩阵,请设计一个算法从左上角(mat[0][0])开始,
 * 顺时针打印矩阵元素.给定int矩阵mat,以及它的维数nxm,请返回一个
 * 数组,数组中的元素为矩阵元素的顺时针输出.
 *
 * 测试样例:
 * [[1,2],[3,4]],2,2
 * 返回:
 *[1,2,4,3]
 *
 */
public class Printer {
    public int[] clockwisePrint(int[][] mat, int n, int m){
        int[] result = new int[n * m];
        int index = 0;
        int left = 0;
        int right = m - 1;
        int up = 0;
        int down = n - 1;

        while (left <= right && up <= down){

            //从左向右遍历
            for (int i = left; i <= right; i++){
                result[index++] = mat[up][i];
            }

            //从上向下遍历
            for (int i = up + 1; i <= down; i++){
                result[index++] = mat[i][right];
            }

            //从右向左遍历
            if (up != down) {
                for (int i = right - 1; i >= left; i--) {
                    result[index++] = mat[down][i];
                }
            }

            //从下向上遍历
            if (left != right) {
                for (int i = down - 1; i > up; i--) {
                    result[index++] = mat[i][left];
                }
            }

            left++;
            right--;
            up++;
            down--;
        }

        return result;
    }
}

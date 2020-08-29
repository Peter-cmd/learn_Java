package t01;

public class Solution {
    public int cutRope(int target) {
        // 若绳子的长度为 2
        if (target == 2){
            return 1;
        }
        // 若绳子的长度为 3
        if (target == 3){
            return 2;
        }
        // 计算不大于 target 的 3 的连乘积的个数
        int x = target / 3;
        // 计算 target 是否可全由 3 构成
        int y = target % 3;

        // 若余数为 0
        if (y == 0){
            return (int)Math.pow(3, x);
        }
        // 若余数为 1
        if (y == 1){
            return (int)(Math.pow(3, x - 1) * 4);
        }
        // 若余数为 2
        if (y == 2){
            return (int)(Math.pow(3, x) * 2);
        }

        return -1;
    }
}
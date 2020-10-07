package greed;

import java.util.Scanner;
public class Main{
    // 保存各面值的硬币
    private static final int[] COIN = {1, 4, 16, 64};
    // 获取最少的硬币
    private static void getLeastCoins(int cost){
        int result = 0;
        // 计算找零
        int change = 1024 - cost;
        // 硬币的种类数
        int n = COIN.length;
        // 优先考虑面值大的硬币进行找零
        for (int i = n - 1; i >= 0; i--){
            // 若找零为 0 跳出循环
            if (change == 0)
                break;
            // 若当前硬币的面值大于找零,选下一个面值次之的硬币
            if (COIN[i] > change)
                continue;
            // 计算满足找零的情况下,最多当前面值的硬币数
            result += change / COIN[i];
            // 更新找零,当前找零为不足当前硬币面值的情况
            change = change % COIN[i];
        }
        System.out.println(result);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int cost = in.nextInt();
            getLeastCoins(cost);
        }
    }
}
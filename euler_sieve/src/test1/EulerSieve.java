package test1;


import java.util.Scanner;

public class EulerSieve {
    public static int[] eulerSieve(int n){
        // 存储质数
        int[] nums = new int[n + 1];
        // 存储 visited 中下标对应的数是否为质数, 若为质数存 0, 不为质数存 1
        int[] visited = new int[n + 1];
        // 质数的判断从 2 开始
        for (int i = 2; i <= n; i++){
            // 若当前的数是质数将当前数加入 nums
            if (visited[i] == 0){
                nums[++nums[0]] = i;
            }
            // 以当前质数数组中的数为质因子, 将 visited 中合数位置置为 1
            for (int j = 1; j <= nums[0] && i * nums[j] <= n; j++){

                visited[i * nums[j]] = 1;

                // 若 i 为 nums[j] 的整数倍, 则跳出循环
                // 当 i 是 nums[j] 的整数倍时,
                // i = nums[j] * k, 此时继续运行,
                // i * nums[j + 1] = nums[j] * k * nums[j + 1]
                // 若 i = k * nums[j + 1]时, 会重复计算
                // 如: i = 8, j = 1, nums[j] = 2, nums[j + 1] = 3
                // 8 * 3 = 2 * 4 * 3 = 2 * 12
                if (i % nums[j] == 0){
                    break;
                }
            }

        }
        return nums;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] result = eulerSieve(n);
            for (int i = 1; i < n; i++){
                if (result[i] == 0){
                    break;
                }
                if (result[i] != 1){
                    System.out.println(result[i]);
                }
            }
        }
    }
}

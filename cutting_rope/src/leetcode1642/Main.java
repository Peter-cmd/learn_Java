package leetcode1642;

public class Main {
    public int cuttingRope(int n) {
        // 处理绳子小于 4的情况
        if (n < 4){
            return n - 1;
        }

        int remainder = n % 3;
        int mod = 1000000007;
        long result = 1, x = 3;
        // 快速幂求余
        for (int a = n / 3 - 1; a > 0; a /= 2){
            if (a % 2 == 1) result = result * x % mod;
            x = x * x % mod;
        }

        if (remainder == 0){
            return (int)(result * 3 % mod);
        }
        if (remainder == 1){
            return (int)(result * 4 % mod);
        }
        return (int)(result * 6 % mod);
    }
}
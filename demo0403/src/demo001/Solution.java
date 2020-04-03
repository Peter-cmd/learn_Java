package demo001;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static int numWays(int n) {

        if (n == 0 || n == 1){
            return 1;
        }

        //定义 f(n) 表示青蛙跳上 n 级台阶的跳法数
        //f(n) = f(n - 1) + f(n - 2);
        //f(0) = 1, f(1) = 1, f(2) = 2;
        //返回值为 f(n) % 1000000007
        BigInteger[] nums = new BigInteger[n + 1];
        nums[0] = new BigInteger("1");
        nums[1] = new BigInteger("1");
        for (int i = 2; i <= n; i++){
            nums[i] = nums[i - 1].add(nums[i - 2]);
        }

        if (nums[n].toString().equals("1000000008")){
            return 1;
        }
        return Integer.parseInt(nums[n].divideAndRemainder(new BigInteger("1000000007"))[1].toString());
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            long result = numWays(n);
            System.out.println(result);
        }
    }
}

package consist;

import java.util.Scanner;

/**
 * 需求: 小明想买 n 个苹果, 苹果的购买方案有两种, 一种是 6 个装的, 一种是 8 个装的;
 * 现在小明想用这两种包装的苹果组合购买, 若刚好可以组合成 n 个苹果, 就买;
 * 反之, 小于和大于 n 都不卖. 请找出小明可以购买的情况下, 所需购买的最少袋数.
 */

public class NConsistOf6And8 {
    private static int consistOf(int n) {
        // 6 和 8 不能组成奇数;
        if (n / 2 == 1) {
            return -1;
        }

        // 该数刚好可以由 8 组成
        if (n % 8 == 0) {
            return n / 8;
        }

        // 不能由 8 组成, 回退, 够买 6 袋的方案
        return n / 8 + 1;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int result = consistOf(n);
            System.out.println(result);
        }
    }
}

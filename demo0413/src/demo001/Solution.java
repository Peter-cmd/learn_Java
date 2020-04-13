package demo001;

/**
 * 问题描述:已知股票连续 n 天的价格走势,以长度为 n 的整数数组表示,
 * 数组中第 i 个元素(prices[i])代表该股票第 i 天的股价.
 * 假设你一开始没有股票,但有至多两次买入 1 股而后卖出 1 股的机会,并且
 * 买入前一定要先保证手上没有股票.若两次交易机会都放弃,收益为 0.
 * 设计算法,计算你能获得的最大收益.输入数值范围: 2 <= n <= 100,
 * 0 <= prices[i] <= 100
 *
 * 输出描述:
 * 输入:
 * 3,8,5,1,7,8
 * 输出:
 * 12
 */

/**
 * f(i, k, 0) 表示第 i 天,可操作次数为 k, 手中无股票获得的最大收益;
 * f(i, k, 1) 表示第 i 天,可操作次数为 k, 手中有股票获得的最大收益;
 * f(i, k, 0) = max{f(i - 1, k, 0}, f(i - 1, k - 1, 1) + prices(i)};
 * f(i, k, 1) = max{f(i - 1, k, 1}, f(i - 1, k, 0) - prices(i)};
 *
 * f(i, 1, 1) = max{f(i - 1, 1, 1}, f(i - 1, 0, 0) -  prices(i)};
 * f(i, 1, 0) = max{f(i - 1, 1, 0}, f(i - 1, 1, 1) +  prices(i)};
 * f(i, 2, 1) = max{f(i - 1, 2, 1}, f(i - 1, 1, 0) -  prices(i)};
 * f(i, 2, 0) = max{f(i - 1, 2, 0}, f(i - 1, 2, 1) +  prices(i)};
 *
 * 其中 f(i - 1, 0, 0) = 0;
 *
 *
 *
 */
/**
 * f(i, k, 0) 表示第 i 天,可操作次数为 k, 手中无股票获得的最大收益;
 * f(i, k, 1) 表示第 i 天,可操作次数为 k, 手中有股票获得的最大收益;
 * f(i, k, 0) = max{f(i - 1, k, 0}, f(i - 1, k - 1, 1) + prices(i)};
 * f(i, k, 1) = max{f(i - 1, k, 1}, f(i - 1, k, 0) - prices(i)};
 *
 *
 * f(i, 1, 0) = max{f(i - 1, 1, 0}, f(i - 1, 1, 1) +  prices(i)};
 * f(i, 1, 1) = max{f(i - 1, 1, 1}, f(i - 1, 0, 0) -  prices(i)};
 * f(i, 2, 0) = max{f(i - 1, 2, 0}, f(i - 1, 2, 1) +  prices(i)};
 * f(i, 2, 1) = max{f(i - 1, 2, 1}, f(i - 1, 1, 0) -  prices(i)};
 *
 * 其中 f(i - 1, 0, 0) = 0;
 *
 *
 *
 *
 */
public class Solution {
    public int maxProfit(int[] prices) {
        //获取股票交易的总天数
        int length = prices.length;
        //
        int profit_i10 = 0;
        int profit_i11 = Integer.MIN_VALUE;
        int profit_i20 = 0;
        int profit_i21 = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++){

            profit_i20 = Math.max(profit_i20, profit_i21 + prices[i]);
            profit_i21 = Math.max(profit_i21, profit_i10 - prices[i]);
            profit_i10 = Math.max(profit_i10, profit_i11 + prices[i]);
            profit_i11 = Math.max(profit_i11, - prices[i]);
        }
        return profit_i20;
    }

}
package array.leetcode_123_买卖股票的最佳时机;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-03 11:47
 * @Description: TODO
 */
public class Solution {

    /**
     * 动态规划
     * <p>0 一直没有买卖</p>
     * <p>1 第一次买 或 延续前一天 取 max </p>
     * <p>2 第一次卖 或 延续前一天 取 max </p>
     * <p>3 第二次买 或 延续前一天 取 max </p>
     * <p>4 第二次卖 或 延续前一天 取 max </p>
     */
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int[][] dp = new int[length][5];
        //初始化
        dp[0][1] = -prices[0]; // 第一次买入
        dp[0][3] = dp[0][2] - prices[0]; // 第二次买入

        for (int i = 1; i < length; i++) {
            dp[i][1] = Integer.max(-prices[i], dp[i - 1][1]);
            dp[i][2] = Integer.max(dp[i][1] + prices[i], dp[i - 1][2]);
            dp[i][3] = Integer.max(dp[i][2] - prices[i], dp[i - 1][3]);
            dp[i][4] = Integer.max(dp[i][3] + prices[i], dp[i - 1][4]);
        }
        return dp[length - 1][4];
    }
}

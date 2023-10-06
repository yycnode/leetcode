package array.leetcode_714_买卖股票的最佳时机含手续费;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-06 17:31
 * @Description: TODO
 */
public class Solution {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // 第 0 天
        dp[0][0] = 0; //0 不持有
        dp[0][1] = -prices[0]; // 1 持有

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    // 空间优化：转移的时候，dp[i] 只会从 dp[i−1]dp[i-1]dp[i−1] 转移得来，因此第一维可以去掉
    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int[] dp = new int[2];
        // 第 0 天
        dp[0] = 0; //0 不持有
        dp[1] = -prices[0]; // 1 持有

        for (int i = 1; i <= n; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }
        return dp[0];
    }

}

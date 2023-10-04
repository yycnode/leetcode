package array.leetcode_188_买卖股票的最佳时机;

class Solution {
    /**
     * 123题改造
     * @param k 最多买卖次数
     * @param prices 股票价格
     * @return 最大收益
     */
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int[][] dp = new int[length][2 * k + 1];
        //初始化
        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = dp[0][i - 1] - prices[0]; // 第i次买入
//            dp[0][3] = dp[0][2] - prices[0]; // 第二次买入
        }

        for (int i = 1; i < length; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if (j % 2 == 1){
                    dp[i][j] = Integer.max(dp[i][j - 1] - prices[i], dp[i - 1][j]);
                }else {
                    dp[i][j] = Integer.max(dp[i][j - 1] + prices[i], dp[i - 1][j]);
                }
//                dp[i][3] = Integer.max(dp[i][2] - prices[i], dp[i - 1][3]);
//                dp[i][4] = Integer.max(dp[i][3] + prices[i], dp[i - 1][4]);
            }
        }
        return dp[length - 1][2 * k];
    }
}
package array.leetcode_122_买卖股票的最佳时机;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-02 13:17
 * @Description: TODO
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int sum = 0; //记录总收益
        int min = prices[0]; //股票开盘
        for (int curr : prices) {
            int profit = curr - min; // 计算收益
            if (curr < min) { //找一个低价位
                min = curr;
            } else if (profit > 0) {
                sum += profit; //收益落袋
                min = curr; //更新当前为低价位，准备重新入场
            }
        }
        return sum;
    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    public int maxProfit3(int[] prices) {
        int cur = 10001;
        int ans = 0;
        for (int p : prices) {
            if (p > cur) {
                ans += p - cur;
            }
            cur = p;
        }
        return ans;
    }

}

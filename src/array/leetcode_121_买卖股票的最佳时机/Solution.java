package array.leetcode_121_买卖股票的最佳时机;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-02 13:07
 * @Description: TODO
 */
public class Solution {
    public int maxProfit(int[] arr) {
        int min = arr[0]; //假设第一天为最低点
        int max = 0; //假设最大收益
        for (int curr : arr) {
            int profit = curr - min; // 当前收益
            if (curr < min) { // 找最低点
                min = curr;
            } else if (profit > max) {
                max = profit;
            }
        }
        return max;
    }
}

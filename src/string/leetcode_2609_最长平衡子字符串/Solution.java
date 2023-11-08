package string.leetcode_2609_最长平衡子字符串;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-11-08 22:33
 * @Description: 最长平衡子字符串
 */
public class Solution {

    /*
    根据题意，平衡子字符串必然满足 0...01...1 格式（前半段全是 0，后半段全是 1，前后两段长度相同）。

    使用变量 idx 对 s 进行遍历。在每轮处理过程中，按照如下流程进行：

    先统计连续段 0 的长度，记为 a；再统计连续段 1 的长度，记为 b（此操作满足：子串中 0 均在 1 前面）
    在 a 和 b 中取较小值，进行乘 2 操作，作为当前平衡子字符串的长度，用于更新答案（此操作满足：子串中 0 和 1 数量相同）
    从当前轮的结束位置 idx，再进行下轮处理（重复步骤 1 和步骤 2），直到 s 处理完成

     */
    public int longestBalancedLength(String s) {
        int n = s.length(), idx = 0, ans = 0;
        while (idx < n) {
            int a = 0, b = 0;
            while (idx < n && s.charAt(idx) == '0' && ++a >= 0) idx++;
            while (idx < n && s.charAt(idx) == '1' && ++b >= 0) idx++;
            ans = Math.max(ans, Math.min(a, b) * 2);
        }
        return ans;
    }
}

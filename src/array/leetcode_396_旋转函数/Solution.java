package array.leetcode_396_旋转函数;

/**
 * @Author: yangyuecheng
 * @Description: 旋转函数
 * @CreateTime: 2023-11-09 17:14
 */
public class Solution {
    /*

    给定一个长度为 n 的整数数组 nums 。

    假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数
    F 为：
    F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
    返回 F(0), F(1), ..., F(n-1)中的最大值 。

    输入: nums = [4,3,2,6]
    输出: 26
    解释:
    F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
    F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
    F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
    F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
    所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26

    解法：推公式
    记数组nums的元素之和为 sum
    根据公式，可以得到：
    F(0)= 0×nums[0] + 1×nums[1] + … + (n−1)×nums[n−1]
    F(1)= 1×nums[0] + 2×nums[1] + … +     0×nums[n−1]  == F(0)+sum−n×nums[n−1]
    更一般地，当 1≤k<n 时，F(k)=F(k−1)+sum−n×nums[n−k]
    我们可以不停迭代计算出不同的 F(k)，并求出最大值

    */

    public int maxRotateFunction(int[] nums) {
        int sum = 0; //数组和
        int max = 0; //函数值
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max += i * nums[i];
        }
        int ans = max;
        for (int i = 1; i < n; i++) {
            max = max + sum - n * nums[n - i];
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 3, 2, 6};
        int maxRotateFunction = solution.maxRotateFunction(nums);
        System.out.println(maxRotateFunction);
    }
}

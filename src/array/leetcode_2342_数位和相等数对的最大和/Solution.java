package array.leetcode_2342_数位和相等数对的最大和;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-11-20 21:36
 * @Description: 数位和相等数对的最大和
 */
public class Solution {

    public int maximumSum(int[] nums) {
        int ans = -1;
        int[] mx = new int[82]; // 81最大的数位和
        for (int num : nums) {
            int s = 0;
            for (int x = num; x > 0; x /= 10) {
                s += x % 10; //得到数位和
            }
            if (mx[s] > 0) { //说明已经赋过值
                ans = Math.max(ans, mx[s] + num);
            }
            mx[s] = Math.max(mx[s], num);
        }
        return ans;
    }
}

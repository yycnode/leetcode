package array.leetcode_2216_美化数组的最少删除数;

/**
 * @Author: yangyuecheng
 * @Description: leetcode_2216_美化数组的最少删除数
 * @CreateTime: 2023-11-21 16:17
 */
public class Solution {

    /*
        思路：无需真删除，只需要统计删除的次数即可
        如果遇到相同的，则一次走一步，删除次数加一，如果遇到不同的，则一次走两步
     */
    public int minDeletion(int[] nums) {
        int n = nums.length;
        int ans = 0;
        if (n == 1) {
            return 1;
        }
        /*
            1,1,2,2,3,3
            1 2 2 3 3
         */
        int i = 0;
        while (i < n - 1) {
            if (nums[i] == nums[i + 1]) {
                ans += 1;
                i += 1;
                continue;
            }
            i += 2;
        }
        return (n - ans) % 2 == 1 ? ans + 1 : ans;
    }

}

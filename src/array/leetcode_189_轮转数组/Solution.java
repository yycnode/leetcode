package array.leetcode_189_轮转数组;

/**
 * @Author: yangyuecheng
 * @Description: 轮转数组
 * @CreateTime: 2023-11-09 16:46
 */
public class Solution {

//    给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//
//
//
//    示例 1:
//
//    输入: nums = [1,2,3,4,5,6,7], k = 3
//    输出: [5,6,7,1,2,3,4]
//    解释:
//    向右轮转 1 步: [7,1,2,3,4,5,6]
//    向右轮转 2 步: [6,7,1,2,3,4,5]
//    向右轮转 3 步: [5,6,7,1,2,3,4]
    /*
      0 1 2 3 4 5 6
      1     1
          7       7


      0 1  k = 3
      1 2

     */

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return;
        }
        int[] ans = new int[n];
        k = k % n; // 考虑k大于n的情况
        System.arraycopy(nums, 0, ans, k, n - k);
        System.arraycopy(nums, n - k, ans, 0, k);
        System.arraycopy(ans, 0, nums, 0, n);
    }

}

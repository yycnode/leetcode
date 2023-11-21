package array.leetcode_2656_K个元素的最大和;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-11-20 21:44
 * @Description: K个元素的最大和
 */
public class Solution {

    public int maximizeSum(int[] nums, int k) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        //求出最大值，再以最大值未首项，前k项和
        return k * ((max + max + k - 1)) >> 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 10, 2, 6, 7, 9, 8, 5, 8, 3, 1, 3, 10, 5, 8, 3, 9, 3, 8, 2, 3, 3, 10, 5, 8, 8, 4, 7, 2, 3, 4,
                3, 10, 8, 7, 9, 1, 3, 4, 2, 6, 6, 9, 6, 2, 10, 10, 4, 6, 3, 4, 1, 1, 3, 8, 4, 10, 3, 9, 5, 3, 10, 4,
                7, 10, 7, 1, 7};
        int i = solution.maximizeSum(nums, 9);
        System.out.println(i);
    }
}

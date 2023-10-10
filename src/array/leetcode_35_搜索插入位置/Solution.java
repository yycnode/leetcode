package array.leetcode_35_搜索插入位置;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-10 14:59
 * @Description: 搜索插入位置
 */
public class Solution {

    // 二分查找
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left + 1;
    }
}

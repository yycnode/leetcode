package array.leetcode_34_在排序数组中查找元素的第一个和最后一个位置;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-10 14:30
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int first = leftMost(nums, target);
        if (first == -1) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, rightMost(nums, target)};
        }
    }
    //找第一个位置
    public int leftMost(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int tep = -1;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                //找到了继续找，直到找到最左边的
                tep = mid;
                right = mid - 1;
            }
        }
        return tep;
    }
    //找最后一个位置
    public int rightMost(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int tep = -1;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                //找到了继续找，直到找到最右边的
                tep = mid;
                left = mid + 1;
            }
        }
        return tep;
    }

}

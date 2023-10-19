package array.leetcode_414_第三大的数;

import java.util.Arrays;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-19 22:53
 * @Description: 第三大的数
 */
public class Solution {

    /* 将数组从大到小排序后，从头开始遍历数组，
      通过判断相邻元素是否不同，来统计不同元素的个数。
      如果能找到三个不同的元素，就返回第三大的元素，否则返回最大的元素*/
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        reverse(nums);
        for (int i = 1, diff = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1] && ++diff == 3) { // 此时 nums[i] 就是第三大的数
                return nums[i];
            }
        }
        return nums[0];
    }

    public static void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        System.out.println("数组中第三大的元素是： " + thirdMax(nums)); // 1
    }

}

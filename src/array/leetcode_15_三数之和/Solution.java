package array.leetcode_15_三数之和;

import java.util.*;

/**
 * @Author: yangyuecheng
 * @Description: leetcode_15_三数之和
 * @CreateTime: 2024-04-07 22:08
 */
public class Solution {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0};
        System.out.println(threeSum(nums));
    }

    /*
    标签：数组遍历
    首先对数组进行排序，排序后固定一个数 nums[i]，
    再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
    如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
    如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
    当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
    当 sum == 0 时，nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R−−
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return result;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                if (sum < 0) {
                    left++;
                }
                if (sum > 0) {
                    right--;
                }
            }
        }
        return result;
    }
}

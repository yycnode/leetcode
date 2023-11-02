package array.leetcode_41_缺失的第一个正数;

import java.util.Arrays;

/**
 * @Author: yangyuecheng
 * @Description: 缺失的第一个正数
 * @CreateTime: 2023-11-02 13:51
 */
public class Solution {

    /*
        找到没有出现过的最小正整数

        将数组进行排序，然后根据条件在进行查找
        排序所需时间复杂度 O(NlogN)
        时间复杂度高
        符合常数阶空间复杂度
     */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        if (nums[0] > 1 || nums[n - 1] <= 0) {
            return 1;
        }
        int i = 0;

        while (i < n - 1) {
            if (nums[i] > 0 && nums[i + 1] - nums[i] > 1) {
                return nums[i] + 1;
            }
            if (nums[i] <= 0 && nums[i + 1] > 1) {
                return 1;
            }
            ++i;
        }

        return nums[n - 1] + 1;
    }


    /*
        原地哈希
        将 1 放到 nums[0] 处
        将 2 放到 nums[1] 处
          ………
     */
    public static int firstMissingPositive2(int[] nums) {
        int n = nums.length;

        int i = 0;
        while (i < n) {
            // 1 <= ans <= len + 1
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
            ++i;
        }

        // 对应不上数据的那个数组下标 + 1，就是答案，
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        // 都对应上了就返回数组长度加 1
        return n + 1;
    }


    public static void swap(int[] nums, int i, int j) {
        int tep = nums[i];
        nums[i] = nums[j];
        nums[j] = tep;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 5, 7};
        System.out.println(firstMissingPositive2(nums));
        System.out.println(Arrays.toString(nums));
    }
}

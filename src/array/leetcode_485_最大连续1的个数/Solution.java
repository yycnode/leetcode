package array.leetcode_485_最大连续1的个数;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-18 16:13
 * @Description: 最大连续1的个数
 */
public class Solution {

    //快慢指针法
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        int j = 0;
        int i = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == 0) {
                i++;
                j++;
            } else {
                if (nums[j] == 1) {
                    j++;
                    count++;
                } else {
                    count = 0;
                    i = j;
                }
            }
            max = Integer.max(max, count);
        }
        return max;
    }

    // 性能更好
    public int findMaxConsecutiveOnes2(int[] nums) {
        int max = 0;
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[slow] == 1) {
                fast++;
                continue;
            }
            max = Integer.max(max, fast - slow);
            //跳过 0 的情况
            while (fast < nums.length && nums[fast] == 0) {
                fast++;
            }
            // 将快慢指针更新为同一起点，此时快指针指向值为1的元素
            slow = fast;
        }
        return Integer.max(max, fast - slow);
    }
}

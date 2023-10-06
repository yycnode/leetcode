package array.leetcode_21_移除元素;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-06 17:43
 * @Description: TODO
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length - 1;
        /*
            数组分为两个区域
            无需被删除的元素区域和待删除的元素区域
            每次匹配到待删除元素就把他和待删除元素区域位置的元素交换
            每交换一次，更新待删除元素区域
         */
        for (int i = 0; i <= length; i++) {
            if (nums[i] == val) {
                swap(nums, i--, length--);
            }
        }
        return length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

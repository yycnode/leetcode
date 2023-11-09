package array.leetcode_283_移动零;

/**
 * @Author: yangyuecheng
 * @Description: 移动零
 * @CreateTime: 2023-11-09 16:12
 */
public class Solution {

    //    输入: nums = [0,1,0,3,12]
//    输出: [1,3,12,0,0]
    //思路：遇到0 就和后续第一个不为0的数交换
    public void moveZeroes(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == 0) {
                int j = i;
                while (j < n && nums[j] == 0) {
                    j++;
                }
                if (j < n) {
                    swap(nums, i, j);
                    i++;
                } else {
                    break;
                }
            } else {
                i++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int nz = 0; // 索引处存放不为0的数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nz != i) {
                    swap(nums, nz++, i); //找到不为0的数就交换，同时更新 noZero 位置
                } else {
                    nz++;
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }

}

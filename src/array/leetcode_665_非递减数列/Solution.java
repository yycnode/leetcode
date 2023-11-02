package array.leetcode_665_非递减数列;

/**
 * @Author: yangyuecheng
 * @Description: 非递减数列
 * @CreateTime: 2023-11-02 16:14
 */
public class Solution {
    //[3,4,2,3]
    //     4
    // 5 7 1 8 true
    // 4 2 1
    // 4 2 3
    public static boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if (n <= 2){
            return true;
        }
        for (int i = 1; i < n - 1; i++) {
            if ((nums[i - 1] > nums[i] && nums[i] > nums[i + 1]) || (nums[i] < nums[i - 1] && nums[i] < nums[i + 1])){
               return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2,3};
        System.out.println(checkPossibility(nums));
    }
}

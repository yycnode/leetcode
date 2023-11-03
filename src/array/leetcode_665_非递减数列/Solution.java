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
        if (n <= 2) {
            return true;
        }
        boolean flag = nums[0] <= nums[1]; // 标识是否还能修改
        // 遍历时，每次需要看连续的三个元素
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) { // 出现递减
                if (flag) {  // 如果还有修改机会，进行修改
                    if (nums[i + 1] >= nums[i - 1]) {// 修改方案1
                        nums[i] = nums[i + 1];
                    } else {  // 修改方案2
                        nums[i + 1] = nums[i];
                    }
                    flag = false;    // 用掉唯一的修改机会
                } else        // 没有修改机会，直接结束
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 3};
        System.out.println(checkPossibility(nums));
    }
}

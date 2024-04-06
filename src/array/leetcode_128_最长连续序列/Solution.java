package array.leetcode_128_最长连续序列;

import java.util.Arrays;

/**
 * @Author: yangyuecheng
 * @Description: leetcode_128_最长连续序列
 * @CreateTime: 2024-04-06 22:34
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));

    }
    public  static  int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length == 1){
            return 1;
        }
        Arrays.sort(nums);
        int max = 0;
        int c;
        for (int i = 1; i < length ; i++) {
            c = i;
            while (i < length && nums[i-1] + 1 == nums[i]){
                i++;
                while (i< length && nums[i - 1] == nums[i]){
                    i++;
                    c = c+1;
                }
            }
            int len = i - c + 1;
            max = Math.max(len,max);
        }
        return max;
    }

}

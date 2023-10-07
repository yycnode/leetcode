package array.leetcode_1_两数之和;

import java.util.HashMap;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-07 14:33
 * @Description: TODO
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}

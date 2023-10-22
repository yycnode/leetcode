package array.leetcode_645_错误的集合;

import java.util.HashMap;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-21 15:59
 * @Description: 错误的集合
 */
public class Solution {

    /*
      首先将数组中元素作为key存入hashmap,如果有重复的key，就找到了重复的元素/被修改的元素
      第二个循环通过判断map中1-n这个区间哪个元素不存子，就找到了丢失的元素
     */
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                result[0] = nums[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
    /*
        重复的数字在数组中出现 2 次，丢失的数字在数组中出现 0 次，
        其余的每个数字在数组中出现 1 次。因此可以使用哈希表记录每个元素在数组中出现的次数，
        然后遍历从 1 到 n 的每个数字，分别找到出现 2 次和出现 0 次的数字，即为重复的数字和丢失的数字
    */

    public int[] findErrorNums2(int[] nums) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i <= n; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) { // 找到了出现两次的，即为重复的数字
                result[0] = i;
            } else if (count == 0) { // 找到了丢失的数字
                result[1] = i;
            }
        }
        return result;
    }
}

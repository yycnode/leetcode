package array.leetcode_697_数组的度;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-24 18:38
 * @Description: 数组的度
 */
public class Solution {

    /*
    输入：nums = [1,2,2,3,1,4,2]
    输出：6
    解释：
    数组的度是 3 ，因为元素 2 重复出现 3 次。
    所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
     */
    public static int findShortestSubArray(int[] nums) {
        /*
            key 保存数字本身
            value[0]保存数字出现的次数
            value[1]保存数字起始下标 (数组长度)
         */
        Map<Integer, Integer[]> map = new HashMap<>();
        // 初始化 次数和数组长度
        int[] max = {1, 1};
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new Integer[]{1, i}); // 初始化第一次出现的数字
            } else {
                // 出现了多次
                Integer[] degree = map.get(nums[i]);
                ++degree[0];
                if (degree[0] > max[0] || (degree[0] == max[0] && i - degree[1] + 1 < max[1])) {// 确保度和长度对应上
                    max[0] = degree[0];
                    max[1] = i - degree[1] + 1; //长度
                }
            }
        }
        return max[1];
    }

    public static void main(String[] args) {
        int[] nums = {6, 6, 6, 7, 7};
        System.out.println(findShortestSubArray(nums));
    }

}

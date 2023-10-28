package array.leetcode_442_数组中重复的数据;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yangyuecheng
 * @Description: 数组中重复的数据
 * @CreateTime: 2023-10-27 23:16
 */
public class Solution {
//    给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，
//    且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
//    输入：nums = [4,3,2,7,8,2,3,1]
//    输出：[2,3]

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int length = nums.length;
        for (int i = 1; i <= length; i++) {
            if (map.containsKey(i) && map.get(i) == 2) {
                list.add(i);
            }
        }
        return list;
    }

    /*
        使用正负号作为标记，如果是负数，证明出现过
        过一遍示例就能理解
     */
    public List<Integer> findDuplicates2(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                ans.add(x);
            }
        }
        return ans;
    }
    /*
        参考448题
     */
    public List<Integer> findDuplicates3(int[] nums) {
        int n = nums.length;
        //将数组中元素减1作为索引，修改索引处的值  1 <= nums[i] <= n        0 <= i <= n - 1
        //每次循环要还原修改过的数字,只是还原出来要作为索引，并不是真的修改
        for (int num : nums) {
            int index = (num - 1) % n;
            nums[index] += n; // 加上数组长度，修改值
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) { // 大于2倍数组长度，证明被修改过两次
                list.add(i + 1); // 索引 + 1，就是重复的数字
            }
        }
        return list;
    }

}

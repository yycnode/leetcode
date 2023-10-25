package array.leetcode_448_找到所有数组中消失的数字;

import java.util.*;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-25 16:38
 * @Description: TODO
 */
public class Solution {
    //    给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
    //    请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
    //    输入：nums = [4,3,2,7,8,2,3,1]
    //    输出：[5,6]
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        //将数组中元素减1作为索引，修改索引处的值  1 <= nums[i] <= n        0 <= i <= n - 1
        //每次循环要还原修改过的数字,只是还原出来要作为索引，并不是真的修改
        for (int num : nums) {
            int index = (num - 1) % n;
            nums[index] += n; // 加上数组长度，修改值
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] < n) { // 小于数组长度，就是没修改过的受罪
                list.add(i + 1); // 索引 + 1，就是丢失的数字
            }
        }
        return list;
    }

}

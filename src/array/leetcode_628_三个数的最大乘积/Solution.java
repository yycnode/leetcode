package array.leetcode_628_三个数的最大乘积;

import java.util.Arrays;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-21 13:31
 * @Description: 三个数的最大乘积
 */
public class Solution {

    /**
     * <p>首先将数组排序</p>
     *
     * <p>如果数组中全是非负数，则排序后最大的三个数相乘即为最大乘积；如果全是非正数，则最大的三个数相乘同样也为最大乘积 </p>
     *
     * <p>如果数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数（即绝对值最大）与最大正数的乘积</p>
     *
     * <P>综上，我们在给数组排序后，分别求出三个最大正数的乘积，以及两个最小负数与最大正数的乘积，二者之间的最大值即为所求答案</P>
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }

    /**
     * 直接遍历，不排序
     * <p>O(N)</p>
     */
    public int maximumProduct2(int[] nums) {
        // 最小的
        int min = Integer.MAX_VALUE;
        // 第二小的
        int smin = Integer.MAX_VALUE;
        // 最大的
        int max = Integer.MIN_VALUE;
        // 第二大的
        int smax = Integer.MIN_VALUE;
        // 第三大的
        int tmax = Integer.MIN_VALUE;

        for (int curr : nums) {
            if (curr < min) { // 找最小的
                smin = min;
                min = curr;
            } else if (curr < smin) { //找第二小的
                smin = curr;
            }

            if (curr > max) { // 找最大的
                tmax = smax;
                smax = max;
                max = curr;
            } else if (curr > smax) { // 找第二大的
                tmax = smax;
                smax = curr;
            } else if (curr > tmax) { // 找第三打的
                tmax = curr;
            }
        }
        return Integer.max(min * smin * max, max * smax * tmax);
    }

}

package array.leetcode_453_最小操作次数使数组元素相等;

/**
 * @Author: yangyuecheng
 * @Description: 最小操作次数使数组元素相等
 * @CreateTime: 2023-11-02 15:51
 */
public class Solution {

    // 核心思想 n - 1 个数加一  变换成 1 个数减一
    // 所以只需要计算所有数字减到最小值所需的次数和
    public static int minMoves(int[] nums) {
//        int min = Arrays.stream(nums).min().getAsInt();
        int min = Integer.MAX_VALUE;
        for (int num : nums){
            if (num < min){
                min = num;
            }
        }
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(minMoves(nums));
    }

}

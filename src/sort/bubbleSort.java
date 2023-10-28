package sort;

import java.util.Arrays;

/**
 * @Author: yangyuecheng
 * @Description: 冒泡排序
 * @CreateTime: 2023-10-28 21:31
 */
public class bubbleSort {

    public static void sort(int[] nums){
        if (nums == null || nums.length == 1){
            return;
        }
        int n = nums.length;
        for (int k = 0; k < n; ++k) {
            for (int i = 1; i < n - k; ++i) {
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
        }
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 3, 1, 6, 8, 5};
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

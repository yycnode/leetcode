package sort;

import java.util.Arrays;

/**
 * @Author: yangyuecheng
 * @Description: 选择排序
 * @CreateTime: 2023-10-28 16:40
 */
public class SelectionSort {

    /*
        每次找到最小值，和未排序区域左边界交换
     */
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int N = nums.length;
        for (int i = 0; i < N; ++i) {
            int minValIndex = i;
            for (int j = i + 1; j < N; ++j) {
                minValIndex = nums[j] < nums[minValIndex] ? j : minValIndex;
            }
            swap(nums, i, minValIndex);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 3, 6, 1, 8, 5};
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}

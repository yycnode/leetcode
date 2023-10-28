package sort;

import java.util.Arrays;

/**
 * @Author: yangyuecheng
 * @Description: 插入排序
 * @CreateTime: 2023-10-28 22:08
 */
public class InsertionSort {

    // 每次将未排序区域左边界，插入到已排序区域
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int currNumIndex = i;
            while (currNumIndex - 1 >= 0 && nums[currNumIndex - 1] > nums[currNumIndex]) { // 左边有数 && 左边数大于当前数 就需要交换
                swap(nums, currNumIndex, currNumIndex - 1);
                currNumIndex--;
            }
//            for (int pre = i - 1; pre >= 0 && nums[pre] > nums[pre + 1]; pre--) {
//                swap(nums, pre, pre + 1);
//            }
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

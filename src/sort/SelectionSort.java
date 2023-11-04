package sort;

import static random.RandomArray.*;

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
        int maxLen = 50;
        int maxValue = 100;
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = lenRandomValueRandom(maxLen, maxValue);
            int[] arr2 = copyArray(arr1);
            SelectionSort.sort(arr1);
            InsertionSort.sort(arr2);
            if (!isSorted(arr1)) {
                System.out.println("选择排序错误");
            }
            if (!isSorted(arr2)) {
                System.out.println("插入排序错误");
            }
        }
    }

}

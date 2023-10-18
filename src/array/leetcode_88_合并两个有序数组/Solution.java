package array.leetcode_88_合并两个有序数组;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-13 14:35
 * @Description: 合并两个有序数组
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0; // 数组1指针
        int j = 0; // 数组2指针
        int[] result = new int[m + n]; // 结果数组
        int k = 0; // 结果数组索引
        while (i <= m - 1 && j <= n - 1) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        // 哪个数组有剩余元素，直接拷贝
        if (i >= m) {
            System.arraycopy(nums2, j, result, k, n - j);
        }
        if (j >= n) {
            System.arraycopy(nums1, i, result, k, m - i);
        }
        // 为了符合题意，再把结果数组拷贝到原数组
        System.arraycopy(result, 0, nums1, 0, m + n);
    }

}

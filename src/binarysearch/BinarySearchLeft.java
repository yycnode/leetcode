package binarysearch;

import random.RandomArray;

import java.util.Arrays;

/**
 * @Author: yangyuecheng
 * @Description: 二分法找最左的位置
 * @CreateTime: 2023-11-04 16:14
 */
public class BinarySearchLeft {

    // arr 有序 找到>= target 的最左的位置
    public static int binarySearchLeft(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;

        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) >> 1;
            if (arr[mid] >= target) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    public static int test(int[] sortedArr, int num) {
        for (int i = 0; i < sortedArr.length; i++) {
            if (sortedArr[i] >= num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr = RandomArray.lenRandomValueRandom(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != binarySearchLeft(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}

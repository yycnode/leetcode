package binarysearch;

import random.RandomArray;

import java.util.Arrays;

/**
 * @Author: yangyuecheng
 * @Description: 二分查找
 * @CreateTime: 2023-11-04 15:53
 */
public class BinarySearch {

    // arr 有序
    public static boolean find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) >> 1;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    public static boolean test(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int testTime = 10000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr = RandomArray.lenRandomValueRandom(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != find(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}

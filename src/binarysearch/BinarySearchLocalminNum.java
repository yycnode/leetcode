package binarysearch;

/**
 * @Author: yangyuecheng
 * @Description: 局部最小
 * @CreateTime: 2023-11-05 20:18
 */
public class BinarySearchLocalminNum {

    // arr 无序 相邻的数不等 找到 局部最小值  arr[i - 1] < arr[i] < arr[i + 1]
    public static int minNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
        if (N == 1) {
            return 0;
        }
        if (N == 2) {
            return arr[0] < arr[1] ? 0 : 1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int L = 0;
        int R = N - 1;
        // L - R 一定有局部最小
        while (L < R - 1) {
            int mid = (L + R) >> 1;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return arr[L] < arr[R] ? L : R;
    }

    // 随机数组，相邻不相等
    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]); // 相等就重做
            }
        }
        return arr;
    }

    public static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        // 是否左边更大
        boolean leftBigger = left < 0 || arr[left] > arr[minIndex];
        // 是否右边更大
        boolean rightBigger = right >= arr.length || arr[right] > arr[minIndex];
        return leftBigger && rightBigger; // 是否满足局部最小
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxLen = 5;
        int maxValue = 20;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int ans = minNum(arr);
            if (!check(arr, ans)) {
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束");
    }
}

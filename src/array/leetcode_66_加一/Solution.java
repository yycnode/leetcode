package array.leetcode_66_加一;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-13 14:06
 * @Description: 加一
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;

        digits[n] = digits[n - 1] + 1; // 直接加一

        while (digits[n] == 10 && n > 0) { // 对10的情况做处理
            digits[n] = 0;
            digits[n - 1] = digits[n - 1] + 1;
            n--;
        }

        if (digits[0] == 10) { // 对第一位是10的情况做扩容
            int[] result = new int[digits.length + 2];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}

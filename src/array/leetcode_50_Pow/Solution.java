package array.leetcode_50_Pow;

/**
 * @Author: yangyuecheng
 * @Description: leetcode_50_Pow(x,n)
 * @CreateTime: 2023-11-22 08:51
 */
public class Solution {

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }

/*      输入：x = 2.10000, n = 3
        输出：9.26100
        输入：x = 2.00000, n = 10
        输出：1024.00000
 */

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x * x, (n - 1) / 2);
        }

    }

}

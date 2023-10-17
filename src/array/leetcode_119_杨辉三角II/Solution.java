package array.leetcode_119_杨辉三角II;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-17 08:57
 * @Description: 杨辉三角II
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int n = rowIndex;
        for (int k = 0; k <= n; k++) {
            result.add(Combination(n, k));
        }
        return result;
    }

    /**
     * 根据组合数学公式，计算出组合数
     * C(n,m) = A(n,m)/m
     *
     * @param n 行
     * @param k 列
     * @return 组合数
     */
    private int Combination(int n, int k) {
        long num = 1; // 定义为long类型，可以通过全部用例
        for (int i = 1; i <= k; i++) {
            num = num * (n - k + i) / i;
        }
        return (int) num;
    }
}

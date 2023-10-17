package array.leetcode_118_杨辉三角;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-17 08:31
 * @Description: 杨辉三角
 */
public class Solution {
    public List<List<Integer>> generate(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> tep = new ArrayList<>();
            int n = i;
            for (int k = 0; k <= n; k++) {
                tep.add(Combination(n, k));
            }
            result.add(tep);
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
        int num = 1;
        for (int i = 1; i <= k; i++) {
            num = num * (n - k + i) / i;
        }
        return num;
    }
}

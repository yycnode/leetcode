package array.leetcode_1276_不浪费原料的汉堡制作方案;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangyuecheng
 * @Description: 不浪费原料的汉堡制作方案
 * @CreateTime: 2023-12-25 18:30
 */
public class Solution {

    /*
        解法：数学方程求解
     */
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list = new ArrayList<>();
        int k = 4 * cheeseSlices - tomatoSlices;
        int y = k / 2;
        int x = cheeseSlices - y;
        if (!(k % 2 != 0 || y < 0 || x < 0)) {
            list.add(x);
            list.add(y);
        } else {

        }
        return list;
    }

}

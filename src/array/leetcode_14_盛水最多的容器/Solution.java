package array.leetcode_14_盛水最多的容器;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-10 15:23
 * @Description: 盛水最多的容器
 */
public class Solution {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        //只需要变动小（低）的一侧
        while (left < right) {
            if (height[left] < height[right]) {
                max = Integer.max(max, height[left] * (right - left));
                left++;
            } else {
                max = Integer.max(max, height[right] * (right - left));
                right--;
            }
        }
        return max;
    }

}

package array.leetcode_26_删除有序数组中的重复项;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-12 22:29
 * @Description: 删除有序数组中的重复项
 */
public class Solution {

    /**
     * <p>一个指针 i 进行数组遍历，另外一个指针 j 指向有效数组的最后一个位置。</p>
     * <p>只有当 i 所指向的值和 j 不一致（不重复），才将 i 的值添加到 j 的下一位置。</p>
     *
     * @param nums
     * @return 去重后数组的长度
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

}

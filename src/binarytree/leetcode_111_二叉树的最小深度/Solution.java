package binarytree.leetcode_111_二叉树的最小深度;

import binarytree.TreeNode;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-03 21:45
 * @Description: TODO
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        //当某一孩子为null时，就不参与深度比较，返回另一子树的深度 + 1
        if (rightDepth == 0){
            return leftDepth + 1;
        }
        if (leftDepth == 0){
            return rightDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }
}

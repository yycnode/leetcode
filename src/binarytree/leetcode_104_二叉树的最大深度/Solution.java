package binarytree.leetcode_104_二叉树的最大深度;

import binarytree.TreeNode;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-03 20:54
 * @Description: TODO
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){ //当节点没有左右孩子，他的深度就是 1
            return 1;
        }
        // 递归找左右子树最大深度，取他们的最大值
        return Math.max(maxDepth(root.left),maxDepth((root.right))) + 1;
    }
}

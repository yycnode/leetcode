package binarytree.leetcode_226_翻转二叉树;

import binarytree.TreeNode;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-03 22:08
 * @Description: TODO
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;
    }

    /**
     * 递归 交换左右孩子
     */
    public void swap(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        swap(node.left);
        swap(node.right);
    }
}

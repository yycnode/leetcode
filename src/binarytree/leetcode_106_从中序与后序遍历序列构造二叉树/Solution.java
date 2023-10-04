package binarytree.leetcode_106_从中序与后序遍历序列构造二叉树;

import binarytree.TreeNode;

import java.util.Arrays;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0){
            return null;
        }
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue){
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                int[] postLeft = Arrays.copyOfRange(postorder, 0, i);
                int[] postRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);
                root.left = buildTree(inLeft,postLeft);
                root.right = buildTree(inRight,postRight);
                break;
            }
        }
        return root;
    }
}
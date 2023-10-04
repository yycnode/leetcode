package binarytree.leetcode_105_从前序与中序遍历序列构造二叉树;

import binarytree.TreeNode;

import java.util.Arrays;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootValue = preorder[0]; // 根元素的值
        TreeNode root = new TreeNode(rootValue);

        //区分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) { //在中序遍历中找到根节点 --- i 的位置
                //中序遍历中找左子树
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                //中序遍历中找右子树
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                //前序遍历中找左子树
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                //前序遍历中找右子树
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                //递归找左右子树的根节点，构造二叉树
                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
                break;
            }
        }
        return root;
    }
}
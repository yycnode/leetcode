package binarytree.leetcode_111_二叉树的最小深度;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-03 21:45
 * @Description: TODO
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        //当某一孩子为null时，就不参与深度比较，返回另一子树的深度 + 1
        if (rightDepth == 0) {
            return leftDepth + 1;
        }
        if (leftDepth == 0) {
            return rightDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 使用层序遍历，遇到的第一个叶子节点所在层数为最小深度
     *
     * @param root
     * @return 最小深度
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minDepth++; // 注意要先 ++
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) { //找到叶子节点，直接返回
                    return minDepth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return minDepth;
    }
}

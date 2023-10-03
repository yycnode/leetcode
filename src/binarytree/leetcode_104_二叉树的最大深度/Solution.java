package binarytree.leetcode_104_二叉树的最大深度;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-03 20:54
 * @Description: TODO
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        if (root.left == null && root.right == null){ //当节点没有左右孩子，他的深度就是 1
//            return 1;
//        }
        // 递归找左右子树最大深度，取他们的最大值
        return Math.max(maxDepth(root.left), maxDepth((root.right))) + 1;
    }

    /**
     * 非递归的后序遍历
     * 栈中的元素个数即为树的深度，只要记录到栈的元素的个数的最大值即为树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        TreeNode curr = root;
        TreeNode pop = null; // 最近一次的弹栈元素
        LinkedList<TreeNode> stack = new LinkedList<>();
        int max = 0; // 记录栈的最大高度，
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                int size = stack.size();
                if (size > max) {
                    max = size; //max记录栈中元素个数的最大值
                }
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) { //处理右子树
                    pop = stack.pop();
                } else {
                    curr = peek.right;
                }
            }
        }
        return max;
    }

    /**
     * 层序遍历
     * 有几层，最大深度就是几
     *
     * @param root
     * @return
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
//        int c1 = 1; //每层有几个元素
        int max = 0;
        while (!queue.isEmpty()) {
//            int c2 = 0;
//            queue.size() 代替 c1
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
//                    c2++;
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
//                    c2++;
                    queue.offer(poll.right);
                }
            }
//            c1 = c2;
            max++;
        }
        return max;
    }
}

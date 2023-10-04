package binarysearchtree;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-04 17:24
 * @Description: 力扣用到的二叉搜索树节点
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

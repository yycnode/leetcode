package binarysearchtree;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-04 17:42
 * @Description: 二叉搜索树
 */
public class BSTTree1 {

    static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    BSTNode root; // 根节点

    /**
     * <h3>查找关键字对应的值</h3>
     *
     * @param key 关键字
     * @return 关键字对应的值
     */
    public Object get(int key) {
        BSTNode node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (node.key < key) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    /**
     * <h3>查找最小关键字对应的值</h3>
     *
     * @return 关键字对应的值
     */
    public Object min() {
        if (root == null) {
            return null;
        }
        BSTNode p = root;
        while (p.left != null){
            p = p.left;
        }
        return p.value;
        /*return doMin(root); // 递归 */
    }

    public Object doMin(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.value;
        }
        return doMin(node.left);
    }

    /**
     * <h3>查找最大关键字对应的值</h3>
     *
     * @return 关键字对应的值
     */
    public Object max() {
        if (root == null) {
            return null;
        }
        BSTNode p = root;
        while (p.right != null){
            p = p.right;
        }
        return p.value;
    }

}
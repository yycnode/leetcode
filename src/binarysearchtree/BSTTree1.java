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

    BSTNode root;

    public Object get(int key) {

        BSTNode p = root;
        while (p != null) {
            /*
                result = -1 key < p.key
                result = 0 key == p.key
                result = 1 key > p.key
             */
            int result = key - p.key;
            if (result < 0) {
                p = p.left;
            } else if (result > 0) {
                p = p.right;
            } else {
                return p.value;
            }
        }
        return null;
    }
}
package binarysearchtree;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-04 17:24
 * @Description: 二叉搜索树 泛型版本
 */

public class BSTTree<K extends Comparable<K>, V> {

    static class BSTNode<K, V> {
        K key;
        V value;
        BSTNode<K, V> left;
        BSTNode<K, V> right;

        public BSTNode(K key) {
            this.key = key;
        }

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    BSTNode<K, V> root;

    public V get(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        BSTNode<K, V> p = root;
        while (p != null) {
            /*
                result = -1 key < p.key
                result = 0 key == p.key
                result = 1 key > p.key
             */
            int result = key.compareTo(p.key);
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

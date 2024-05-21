package com.axing;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @projectName: Leetcode
 * @package: com.axing
 * @className: Problem100
 * @author: Axing
 * @description: TODO
 * @date: 2024/5/15 上午9:32
 * @version: 1.0
 */
public class Problem100 {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1, null, null);
        TreeNode left = new TreeNode(2, null, null);
        TreeNode right = new TreeNode(3, null, null);
        t.left = left;
        t.right = right;
        Problem100 p = new Problem100();
        System.out.println(p.isSameTree(t, t));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueP.offer(p);
        queueQ.offer(q);
        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode t1 = queueP.poll();
            TreeNode t2 = queueQ.poll();
            if (t1.val != t2.val) return false;
            TreeNode left1 = t1.left, left2 = t2.left, right1 = t1.right, right2 = t2.right;
            if ((left1 == null ^ left2 == null) || (right1 == null ^ right2 == null))
                return false;
            if (left1 != null) queueP.offer(left1);
            if (right1 != null) queueP.offer(right1);
            if (left2 != null) queueQ.offer(left2);
            if (right2 != null) queueQ.offer(t2.right);
        }
        return true;
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        /**
         * 获取
         *
         * @return val
         */
        public int getVal() {
            return val;
        }

        /**
         * 设置
         *
         * @param val
         */
        public void setVal(int val) {
            this.val = val;
        }

        /**
         * 获取
         *
         * @return left
         */
        public TreeNode getLeft() {
            return left;
        }

        /**
         * 设置
         *
         * @param left
         */
        public void setLeft(TreeNode left) {
            this.left = left;
        }

        /**
         * 获取
         *
         * @return right
         */
        public TreeNode getRight() {
            return right;
        }

        /**
         * 设置
         *
         * @param right
         */
        public void setRight(TreeNode right) {
            this.right = right;
        }

        public String toString() {
            return "TreeNode{val = " + val + ", left = " + left + ", right = " + right + "}";
        }
    }
}

package com.springbatch.demo.jianzhi;

import com.springbatch.demo.mianshi.TreeNode;

/**
 * 二叉树 判断是否对称
 */
public class T28 {
    public boolean isSymmetric(TreeNode root) {
        return root ==null?true:recur(root.left,root.right);
    }
    private boolean recur(TreeNode left,TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return recur(left.left,right.right) && recur(left.right,right.left);
    }
}

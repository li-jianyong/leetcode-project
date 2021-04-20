package com.springbatch.demo.jianzhi;

import com.springbatch.demo.leetcode.TreeNode;

/**
 * 判断是否为平衡树
 */
public class T55 {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }
    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
    }
    // 方法2
    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        // 如果左子树不平衡，直接返回false
        if (!isBalanced2(root.left)) {
            return false;
        }
        // 如果右子树不平衡，直接返回false
        if (!isBalanced2(root.right)) {
            return false;
        }
        // 算出左子树的高度
        int l = getDepth(root.left);
        // 算出右子树的高度
        int r = getDepth(root.right);
        if (Math.abs(r-l) > 1) {
            return false;
        }
        return true;
    }
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getDepth(root.left) + 1;
        int r = getDepth(root.right) + 1;
        return r > l ? r : l;
    }
}

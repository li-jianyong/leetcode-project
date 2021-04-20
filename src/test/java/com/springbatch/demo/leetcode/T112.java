package com.springbatch.demo.leetcode;

/**
 * 路径和，根节点到叶子节点的路径和是否等于给定数字,仅仅返回true/false
 */
public class T112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum-root.val);
    }

}
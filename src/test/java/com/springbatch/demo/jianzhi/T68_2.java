package com.springbatch.demo.jianzhi;

import com.springbatch.demo.leetcode.TreeNode;

/**
 * 二叉树的最近公共祖先
 */
public class T68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 说明不在左子树上，直接返回right
        if(left == null) return right;
        // 说明不在右子树上，直接返回left
        if(right == null) return left;
        return root;
    }
}

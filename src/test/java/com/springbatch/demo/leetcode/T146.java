package com.springbatch.demo.leetcode;

/**
 * 二叉树最大路径和
 */
public class T146 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    int maxGain(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(maxGain(root.left),0);
        int right = Math.max(maxGain(root.right),0);
        // 当前节点作为根的最大路径和
        int priceNewPath = root.val + left + right;
        // 每次迭代出最大值
        maxSum = Math.max(maxSum,priceNewPath);
        // 算出当前节点能够向上贡献的最大值 最大值包括自己当前节点的值和左右节点能够贡献的最大值
        return root.val + Math.max(left,right);
    }
}

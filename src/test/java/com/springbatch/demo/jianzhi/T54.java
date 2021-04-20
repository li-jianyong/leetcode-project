package com.springbatch.demo.jianzhi;

import com.springbatch.demo.leetcode.TreeNode;

/**
 * 求第K大的数字
 */
public class T54 {
    private int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k=k;
        // 维护一个小根堆
        recur(root);
        return res;
    }
    private void recur(TreeNode node) {
        if(node == null) return;
        recur(node.right);
        // 前中后的区别在于，什么时机处理根节点的值
        if(k==0) return;
        if (--k==0) res = node.val;
        recur(node.left);

    }
}

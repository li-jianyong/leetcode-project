package com.springbatch.demo.mianshi;

/**
 * @ClassName:T54
 * @author: Administrator
 * @Date: 2020/10/21 13 53
 **/
public class T54 {
    int res, k;
    public int kthLargest(TreeNode root,int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if (root ==null) return;
        dfs(root.right);
        if (k==0) return;
        // 已经找到K大，直接返回此时的值
        if (--k == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }
}

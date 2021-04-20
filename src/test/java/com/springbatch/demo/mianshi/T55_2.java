package com.springbatch.demo.mianshi;

/**
 * @ClassName:T55_2
 * @author: Administrator
 * @Date: 2020/10/21 15 44
 **/
public class T55_2 {
    public boolean isBalanced(TreeNode root)  {
        return recur(root) != -1;
    }
    // 递归遍历左右子树的深度
    int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left==-1) return -1;
        int right = recur(root.right);
        if (right==-1) return -1;
        // 如果当前节点的左右子树深度差小于2，那么返回该左/右子树深度最大值+1
        return Math.abs(left - right) < 2?Math.max(left,right) + 1 : -1;
    }
}

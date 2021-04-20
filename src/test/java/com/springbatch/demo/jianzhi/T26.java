package com.springbatch.demo.jianzhi;

import com.springbatch.demo.mianshi.TreeNode;

/**
 * 判断两颗树的是否为子树关系
 * 递归解法
 */
public class T26 {
    public boolean  isSubStructure(TreeNode A,TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSub(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    private boolean isSub(TreeNode A,TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val !=B.val) return false;
        return isSub(A.left,B.left) && isSubStructure(A.right,B.right);
    }
}

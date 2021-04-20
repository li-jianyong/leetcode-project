package com.springbatch.demo.leetcode;

import java.util.Stack;

/**
 * @ClassName:T98
 * @author: Administrator
 * @Date: 2020/10/12 21 27
 **/
public class T98 {
    public boolean isValidBST(TreeNode root) {
//        if (root==null) {
//            return true;
//        }
//        // 如果左孩子不为空并且根节点值小于左孩子的值  或者  右孩子不为空并且根节点大于右孩子  这两种情况都属于不合法BST
//        if (root.left !=null && root.val <= root.left.val || root.right!=null && root.val >= root.right.val) return false;
//        return isValidBST(root.left) && isValidBST(root.right);
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /** 规定好上下界比较，不会出现左孩子比祖父节点大的情况
     * @param root
     * @param minVal
     * @param maxVal
     * @return
     */
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        //每个节点如果超过这个范围，直接返回false
        if (root.val >= maxVal || root.val <= minVal)
            return false;
        //这里再分别以左右两个子节点分别判断，
        //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
        //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
    // 非递归写法
    private boolean isValidBST1(TreeNode root) {
        if (root==null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root!=null || !stack.isEmpty()) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre!=null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}

package com.springbatch.demo.leetcode;


import java.util.Deque;
import java.util.LinkedList;

/** 恢复二叉树 找到错误的两个节点 BST树的经典遍历方式  迭代遍历时间复杂度由于递归遍历方式！！！
 * @ClassName:T99
 * @author: Administrator
 * @Date: 2020/10/12 21 07
 **/
public class T99 {
    // BST中序递增，找到两个前面节点值大于后面节点值的两个点
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode p = root;
        while (p!=null || !stack.isEmpty()) {
            while(p!=null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (firstNode ==null && pre.val > p.val) {
                firstNode = pre;
            }
            if (firstNode != null && pre.val > p.val) {
                secondNode = p;
            }
            pre = p;
            p = p.right;
        }
        // firstNode、secondNode值进行交换
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }
    // 编写递归遍历写法

}

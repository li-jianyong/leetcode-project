package com.springbatch.demo.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 给定一个二叉树，返回它的中序 遍历
 * @ClassName:T94
 * @author: Administrator
 * @Date: 2020/10/12 19 10
 **/
public class T94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root!=null) {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            // 弹出栈里元素
            root = stack.pop();
            // 加入根节点
            rs.add(root.val);
            // 尝试遍历right
            root = root.right;
        }
        return rs;
    }
}

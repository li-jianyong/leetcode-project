package com.springbatch.demo.jianzhi;

import com.springbatch.demo.mianshi.TreeNode;

import java.util.Stack;

/**
 * 二叉树镜像
 */
public class T27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root ==null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
    // 解法2 辅助队列或者栈遍历每个节点，交换左右子节点
    public TreeNode mirrorTree1(TreeNode root) {
        if (root ==null) return null;
        // 栈里添加元素，每次取出，然后将左右节点作为父节点加入到栈里，交换左右子树，然后下一个循环，交换左右子树；
        Stack<TreeNode> stack = new Stack<TreeNode>(){{add(root);}};
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left!=null) stack.add(node.left);
            if (node.right!=null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

}

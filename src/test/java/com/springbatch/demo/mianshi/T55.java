package com.springbatch.demo.mianshi;


import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName:T55
 * @author: Administrator
 * @Date: 2020/10/21 14 52
 **/
public class T55 {
    // DFS遍历
    public int maxDepth(TreeNode root) {
        if (root ==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth((root.right))) + 1;
    }
    // BFS遍历
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> tmp;
        int res = 0;
        while(!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left!=null) tmp.add(node.left);
                if (node.right!=null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;

    }
}

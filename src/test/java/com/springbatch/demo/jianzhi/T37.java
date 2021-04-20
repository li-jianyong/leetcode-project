package com.springbatch.demo.jianzhi;

import com.springbatch.demo.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/** 正反序列化二叉树
 * @ClassName:T37
 * @author: Administrator
 * @Date: 2021/1/1 17 55
 **/
public class T37 {
    // BFS用队列来实现
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        // 静态块初始化
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else res.append("null,");
        }
        // 去除尾逗号
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }
    // 反序列化
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            // 第二个元素是右节点
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}

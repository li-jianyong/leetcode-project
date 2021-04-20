package com.springbatch.demo.jianzhi;

/** 剑指 Offer 36. 二叉搜索树与双向链表
 * @ClassName:T36
 * @author: Administrator
 * @Date: 2021/1/1 16 57
 **/
public class T36 {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        // pre指向末尾节点
        head.left = pre;
            pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) return;
        // 深度遍历到末尾左子叶节点
        dfs(cur.left);
        // 此时pre为null,将head指向当前cur节点
        if(pre != null) pre.right = cur;
        else head = cur;
        // 当前cur位置的左侧指向pre
        cur.left = pre;
        // 往后移动
        pre = cur;
        dfs(cur.right);
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node(int val,Node left,Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


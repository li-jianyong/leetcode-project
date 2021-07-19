package com.springbatch.demo.binaryTree;

import com.springbatch.demo.leetcode.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/** 二叉树遍历
 * @author: lijianyong
 * @since: 2021/6/26 11:26
 */
public class TreeIterator {

    @Before
    public void init() {
        res = new ArrayList<>();
    }

    /**
     * 测试二叉树的遍历，
     */
    @Test
    public void test() {
    }

    /** 前序遍历 根-左-右
     * @param node
     */
    List<Integer> res;
    void preOrder(TreeNode node) {
        // 如果节点为null，结束掉当前流程
        if (node == null) return;
        res.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    /** 中序遍历结果
     * @param node
     */
    void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        res.add(node.val);
        inOrder(node.right);
    }

    /** 二叉树后序遍历
     * @param node
     */
    void postOrder(TreeNode node ) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        res.add(node.val);
    }


    /** 二叉树层次遍历，访问某一层后再访问下一层，所以需要保留下一层的引用；
     * 将根节点指针入队，从队头取出第一个元素，处理元素数据，将该元素的左右指针入队，直到队列为空
     * 可以延伸为 BFS的遍历 典型层序遍历算法框架
     * @param root
     */
    void rankOrder(TreeNode root) {
        if (root == null) return;
        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>(){{addLast(root);}};
        while(!q.isEmpty()) {
            TreeNode node = new TreeNode();
            res.add(node.val);
            if (node.left!=null) q.addLast(node.left);
            if (node.right!=null) q.addLast(node.right);
        }
    }
}

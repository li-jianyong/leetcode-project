package com.springbatch.demo.mianshi;

/**
 * @ClassName:TreeNode
 * @author: Administrator
 * @Date: 2020/10/21 13 54
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

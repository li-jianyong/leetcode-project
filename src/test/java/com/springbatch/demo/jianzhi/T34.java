package com.springbatch.demo.jianzhi;


import com.springbatch.demo.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/** 剑指 Offer 34. 二叉树中和为某一值的路径
 * @ClassName:T34
 * @author: Administrator
 * @Date: 2020/10/27 17 26
 **/
public class T34 {
    //先序遍历 + 路径记录 回溯
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root,int sum) {
        recur(root,sum);
        return res;
    }
    void recur(TreeNode root, int tar) {
        if (root ==null) return;
        // 先减去根节点的值
        path.add(root.val);
        tar -= root.val;
        // 如果减到0了，且是叶节点，满足规则
        if (tar==0 && root.left ==null && root.right==null) {
            res.add(new LinkedList(path));
        }
        // 先左后右
        recur(root.left,tar);
        recur(root.right,tar);
        // 回溯
        path.removeLast();
    }

}

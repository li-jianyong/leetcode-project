package com.springbatch.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回树中路径和等于给定数字的所有路径,要去必须到达叶子节点，
 */
public class T113 {
    public List<List<Integer>> pathSum(TreeNode root,int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,sum,new ArrayList<>(),res);
        return res;
    }

    /**
     * @param root 当前节点
     * @param sum 当前累计的和
     * @param list 存放当前临时结果
     * @param res 总的结果集
     */
    void dfs(TreeNode root,int sum,List<Integer> list,List<List<Integer>> res) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        dfs(root.left, sum - root.val, list, res);
        dfs(root.right, sum - root.val, list, res);
        list.remove(list.size() - 1);
    }
}

package com.springbatch.demo.leetcode;

import java.util.*;

/** 数组元素可重复选择，找出不重复结果的列表集合，列表元素和等于target
 *  思路： 回溯法 + 深度优先 剪枝顺序排好数组，每次都从头开始寻找，从begin位置开始搜索
 * @ClassName:T39
 * @author: Administrator
 * @Date: 2020/12/14 21 26
 **/
public class T39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            // 每次都从头开始搜索
            path.addLast(candidates[i]);
            dfs(candidates,i,len,target-candidates[i],path,res);
            path.removeLast();
        }
    }
}

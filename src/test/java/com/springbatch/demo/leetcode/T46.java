package com.springbatch.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/** 全排列
 * @ClassName:T46
 * @author: Administrator
 * @Date: 2020/12/14 20 13
 **/
public class T46 {
    /** 回溯 + 深度优先遍历
     * @param nums 给定数组的元素
     * @return  返回由元素数字组成的全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        boolean[] used = new boolean[len];
        ArrayList<Integer> path = new ArrayList<>();
        dfs(nums,len,0,path,used,res);
        return res;
    }

    /**
     * @param nums 需要参与全排列的数组
     * @param len 数组长度
     * @param depth 当前遍历深度
     * @param path 当前组合类型
     * @param used 是否使用该数字
     * @param res 收集结果容器
     */
    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res){
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<len;i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,len,depth+1,path,used,res);
                // 状态反转
                used[i] = false;
                // 移除最后添加进来的元素
                path.remove(path.size()-1);
            }
        }

    }
}

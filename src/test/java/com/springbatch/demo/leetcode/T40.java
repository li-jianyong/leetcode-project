package com.springbatch.demo.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName:T0
 * @author: Administrator
 * @Date: 2020/12/14 22 05
 **/
public class T40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len==0) return res;
        Deque<Integer> path = new ArrayDeque<>(len);
        Arrays.sort(candidates);
        dfs(candidates,0,len,target,path,res);
        return res;
    }
    private void dfs(int[] candidates,int begin,int len,int target,Deque<Integer> path,List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin;i<len;i++) {
            // 大剪枝，小于0的后面都不用考虑
            if(target - candidates[i] < 0) {
                System.out.println("当前递归栈结束，产生负值：" + (target - candidates[i]));
                break;
            };
            // 同一层数，相同数字去掉
            if (i > begin && candidates[i] == candidates[i-1]) continue;
            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            dfs(candidates,i+1,len,target-candidates[i],path,res);
            path.removeLast();
            System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));
        }
    }
    @Test
    public void t(){
        int[] arr = {10,1,2,7,6,1,5};

        System.out.println(combinationSum2(arr, 8));

        System.out.println();
    }
}

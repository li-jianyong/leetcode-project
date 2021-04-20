package com.springbatch.demo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**给定两个数字k,n返回1-k的数字，长度为n的任意组合
 * @ClassName:T77
 * @author: Administrator
 * @Date: 2020/12/17 14 54
 **/
public class T77_1 {
    public List<List<Integer>> combine(int n,int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k<=0||n<k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n,k,1,path,res);
        return res;
    }
    private void dfs(int n,int k,int begin,Deque<Integer> path,List<List<Integer>> res) {
        if (0 == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (begin > n-k+1) {
            return;
        }
        dfs(begin+1,n,k,path,res);
        path.addLast(begin);
        dfs(begin+1,n,k-1,path,res);
        path.removeLast();
    }
}

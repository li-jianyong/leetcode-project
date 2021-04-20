package com.springbatch.demo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/** 131. 分割回文串 回溯
 * @ClassName:T131
 * @author: Administrator
 * @Date: 2020/10/27 11 18
 **/
public class T131 {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res= new ArrayList<>();
        if (len ==0) return res;
        // 作为路径path存放，达到深度之后，收集结果
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s,0,len,stack,res);
        return res;
    }
    private void backtracking(String s,int start,int len,Deque<String> path,List<List<String>> res) {
        if (start == len) {
            // 放进去的是path的拷贝
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<len;i++) {
            if (!checkPalindromes(s,start,i)) {
                continue;
            }
            // 截取一个start字符 添加到最后
            path.addLast(s.substring(start,i+1));
            // 尝试从start+1开始向后搜索
            backtracking(s,i+1,len,path,res);
            // 逆转
            path.removeLast();
        }
    }
    // 检查str串的left~right之间是否回文
    private boolean checkPalindromes(String str,int left,int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 动态规划 + 回溯 ，解法优化 动态规划判断子串是否回文
    public List<List<String>> partition1(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len ==0) {
            return res;
        }
        boolean[][] dp = new boolean[len][len];
        for (int right = 0;right<len;right++) {
            for (int left=0;left<=right;left++) {
                if (s.charAt(left) == s.charAt(right) && (right-left <= 2 || dp[left+1][right-1])) {
                    dp[left][right] = true;
                }
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        backtracking1(s,0,len,dp,stack,res);
        return res;
    }

    private void backtracking1(String s, int start, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<len;i++) {
            if (!dp[start][i]) {
                continue;
            }
            path.addLast(s.substring(start,i+1));
            backtracking1(s,i+1,len,dp,path,res);
            path.removeLast();
        }
    }


}

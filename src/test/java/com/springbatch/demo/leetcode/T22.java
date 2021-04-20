package com.springbatch.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/** 括号生成
 * @ClassName:T22
 * @author: Administrator
 * @Date: 2020/12/14 19 59
 **/
public class T22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n ==0) {
            return res;
        }
        // 做减法
        dfs("",n,n,res);
        // 做加法
        dfs1("",0,0,n,res);
        return res;
    }
    // left表示剩余的左括号数量，right表示剩余的右括号的数量
    private void dfs(String curStr,int left,int right,List<String> res) {
        if (left ==0 && right == 0) {
            res.add(curStr);
            return;
        }
        // 如果当前串的左括号剩余数量已经大于右括号剩余数量，代表已经当前串里已经有多余的右括号，这代表不合法串
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(curStr + "(",left-1,right,res);
        }
        if (right > 0) {
            dfs(curStr + ")",left,right-1,res);
        }
    }

    /** 通过减法完成回溯
     * @param curStr 当前串
     * @param left 当前串里已经使用了的左括号
     * @param right 当前串里已经使用了的右括号
     * @param n 可使用的括号对数
     * @param res 返回list结果
     */
    private void dfs1(String curStr,int left,int right,int n,List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }
        if (left < right) {
            return;
        }
        // 当前使用的左括号数小于n,继续向后深度搜索
        if (left < n) {
            dfs1(curStr + "(",left+1,right,n,res);
        }
        if (right < n) {
            dfs1(curStr+")",left,right+1,n,res);
        }
    }

}

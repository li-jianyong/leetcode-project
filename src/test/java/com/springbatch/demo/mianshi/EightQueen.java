package com.springbatch.demo.mianshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** N皇后问题
 * @ClassName:EigthQueen
 * @author: Administrator
 * @Date: 2020/12/23 17 20
 **/
public class EightQueen {
    public List<List<String>> solveEightQueen(int n) {
        // 初始化每个棋盘格为'.'
        char[][] arr = new char[n][n];
        Arrays.fill(arr,'.');
        List<List<String>> res = new ArrayList<>();
        // 深度遍历棋盘每个位置
        dfs(arr,0,n,res);
        return res;
    }

    /**
     * @param arr 要遍历的数组
     * @param x 遍历到的当前行x
     * @param n 总共要遍历到n行
     * @param res 收集结果
     */
    private void dfs(char[][] arr,int x,int n,List<List<String>> res) {
        // base case 当遍历达到n的时候，就可以开始收集结果了
        if (x == n) {
            List<String> ans = new ArrayList<>();
            for (int i=0;i<n;i++) {
                StringBuilder tmp = new StringBuilder();
                    // 从0开始遍历每一行
                for (int j=0;j<n;j++) {
                    // 如果不是就添加Q
                    if (arr[i][j]=='.') {
                        tmp.append('.');
                    } else {
                        tmp.append('Q');
                    }
                }
                ans.add(tmp.toString());
            }
            res.add(ans);
        }
        // 按列遍历检测
            for (int y=0;y<n;y++) {
                // 检查x行第y列的元素位置的情况
                if (check(arr,x,y,n)) {
                    arr[x][y] = 'Q';
                    dfs(arr,x+1,n,res);
                    arr[x][y]='.';
                }
            }
            return;
    }

    /** 检查（x,y）坐标的二维数组的攻击情况，
     * @param arr
     * @param x
     * @param y
     * @param n
     * @return
     */
    private boolean check(char[][] arr,int x,int y,int n) {
        // 上方，从0行到x行，如果有元素在这一列占据位置了，就返回false
        for (int i=0;i<x;++i) {
            if (arr[x][y] == 'Q') {
                return false;
            }
        }
        // 考虑左上-右下 形状对角线的情况，每次都往对角线上方遍历寻找结果，如果存在元素就直接返回false
        int i = x-1,j=y-1;
        while(i>=0&&j>=0) {
            if (arr[i][j]=='Q') {
                return false;
            }
            i--;
            j--;
        }
        i = x-1;
        j= y +1;
        while(i>=0&&j<n) {
            if (arr[i][j]=='Q') {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}

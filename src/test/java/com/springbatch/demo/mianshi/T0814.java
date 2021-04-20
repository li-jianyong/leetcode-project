package com.springbatch.demo.mianshi;

import java.util.Arrays;

/** 计算括号的数量
 * @ClassName:T0814
 * @author: Administrator
 * @Date: 2020/12/28 21 02
 **/
public class T0814 {
    private char[] arr;
    // 设dp[s][e][r]为从索引s到索引e值为r的方案数
    private int[][][] dp;
    private int getBoolAns(int val1, int val2, char operator) {
        switch (operator) {
            case '&':
                return val1 & val2;
            case '|':
                return val1 | val2;
            case '^':
                return val1 ^ val2;
        }
        return val1 & val2;
    }
    /**
     * 返回从索引start到end值为result的不同括号方案的个数
     */
    private int rec(int start, int end, int result) {
        // 遍历结束，判断字符数组起始位置是否为
        if (start == end) {
            return arr[start] - '0' == result ? 1 : 0;
        }
        if (dp[start][end][result] != -1) {
            return dp[start][end][result];
        }
        int ansCount = 0;
        for (int k = start; k < end; k += 2) {
            char operator = arr[k + 1];
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    if (getBoolAns(i, j, operator) == result) {
                        ansCount += rec(start, k, i) * rec(k + 2, end, j);
                    }
                }
            }
        }
        dp[start][end][result] = ansCount;
        return ansCount;
    }
    public int countEval(String s, int result) {
        arr = s.toCharArray();
        int len = arr.length;
        dp = new int[len][len][2];
        // 三维数组每个位置的元素的值设置为-1；
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return rec(0, len - 1, result);
    }
}

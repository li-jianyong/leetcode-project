package com.springbatch.demo.leetcode;

/**
 * 不同的子序列 两个字符串s,t 计算在s的子序列中t出现的个数；
 * 动态规划 dp[i][j]
 */
public class T115 {
    public int numDistinct(String s, String t) {
//        动态规划 dp[i][j] 代表t的前i个字符串可以由t
        int[][] dp = new int[t.length()+1][s.length()+1];
        for (int j = 0;j<s.length()+1;j++) dp[0][j] = 1;
        // dp二维数组的行
        for (int i=1;i<t.length()+1;i++) {
            // dp二维数组的列
            for (int j=1;j<s.length()+1;j++) {
                if (s.charAt(j-1) == t.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}

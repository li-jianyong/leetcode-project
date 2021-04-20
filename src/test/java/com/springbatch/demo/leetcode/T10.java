package com.springbatch.demo.leetcode;

/**
 * @ClassName:T
 * @author: Administrator
 * @Date: 2020/12/5 11 57
 **/
public class T10 {
    // dp[i][j]表示s串0~i-1,p串0~j-1是否匹配
    public boolean isMath(String s,String p) {
        if (s==null || p == null) return false;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i=2;i<=n;i+=2) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1);
                if (sc ==pc || pc=='.') {
                    // 如果当前的i-1和j-1字符相等，则只需要判断前面的即可
                    dp[i][j] = dp[i-1][j-1];
                } else if(pc == '*') {
                    // p串是*号，那么判断*号前面一位和i串最后一位的匹配情况，如果匹配，可以让*号是1，就是能够匹配上
                    if (dp[i][j-2]) {
                        dp[i][j] = true;
                        // 如果匹配不上，那就*号就要让j-2位置的字符消失掉。
                        // 如果与p串j-2的位置一样，或者j-2位置为一个万能字符
                    } else if (sc == p.charAt(j-2) || p.charAt(j-2)=='.') {
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}

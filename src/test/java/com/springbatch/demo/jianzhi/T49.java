package com.springbatch.demo.jianzhi;

/**
 * 计算第n个丑数 只能有前一个丑数乘2，3，5其中一个得到 所以第一个丑数是1，也就是第二个丑数只能是乘2，3，5其中一个得到
 */
public class T49 {
    // 动态规划解法
    public int nthUglyNumber(int n) {
        int a=0,b=0,c=0;
        int[] dp = new int[n];
        dp[0]=1;
        for (int i=1;i<n;i++) {
            int n2 = dp[a] * 2,n3 = dp[b]*3,n5=dp[c]*5;
            dp[i] = Math.min(n2,Math.min(n3,n5));
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n-1];
    }
}

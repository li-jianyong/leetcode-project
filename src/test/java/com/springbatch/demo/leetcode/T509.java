package com.springbatch.demo.leetcode;

/**
 * @author: lijianyong
 * @since: 2021/7/11 16:22
 */
public class T509 {
    public int fib(int n) {
        // 滚动数组
        if (n<2) return n;
        int p=0,q=0,r=1;
        for (int i=2;i<=n;i++) {
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }
    // 动态规划。
    int fib2(int n) {
        if (n== 2 || n==1) {
            return 1;
        }
        int prev = 1,curr = 1;
        for (int i=3;i<=n;i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        int[] dp = new int[n+1];
        return curr;
    }
}

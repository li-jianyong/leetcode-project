package com.springbatch.demo.leetcode;

/**
 * @ClassName:T188
 * @author: Administrator
 * @Date: 2020/10/19 17 02
 **/
public class T188 {
    public int maxProfit(int k,int[] prices) {
        if (prices == null || prices.length==0) return 0;
        int n = prices.length;
        if (k >= n/2) {
            int dp0 = 0,dp1=-prices[0];
            for (int i=1;i<n;i++) {
                int tmp = dp0;
                dp0 = Math.max(dp0,dp1+prices[i]);
                dp1 = Math.max(dp1,dp0-prices[i]);
            }
            return Math.max(dp0,dp1);
        }
        return dfs(0,0,0,k,prices);
    }
    private int dfs(int index,int status,int count,int k,int[] prices) {
        if (index == prices.length || count==k){
            return 0;
        }
        int a=0,b=0,c=0;
        a = dfs(index+1,status,count,k,prices);
        if (status==1) {
            b = dfs(index+1,0,count+1,k,prices) + prices[index];
        } else {
            c = dfs(index+1,1,count+1,k,prices) + prices[index];
        }
        return Math.max(Math.max(a,b),c);
    }
}

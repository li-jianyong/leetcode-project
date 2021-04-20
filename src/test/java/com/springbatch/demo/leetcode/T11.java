package com.springbatch.demo.leetcode;

import java.util.Arrays;

/**
 * @ClassName:T11
 * @author: Administrator
 * @Date: 2020/12/5 15 15
 **/
public class T11 {
    public int maxArea(int[] height) {
        // 从左往右 算出 i柱子为最左的面积
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);
        for (int i=0;i<n;i++) {
            for (int j = 1;j<n;j++) {
                dp[i] = Math.max(dp[i],(j-i) * Math.min(height[i],height[j]));
            }
        }
        int res = Integer.MIN_VALUE;
        for (int k=0;k<n;k++){
            res = Math.max(res,dp[k]);
        }
        return res;
    }
    // 双指针法
    public int maxArea1(int[] height) {
        int i=0,j=height.length-1,res=0;
        while(i<j) {
            res = height[i]<height[j] ?
                    // 向后移动短板
                    Math.max(res,(j-i) * height[i++]) :
                    // 向前移动短板
                    Math.max(res,(j-i)*height[j--]);
        }
        return res;
    }
}

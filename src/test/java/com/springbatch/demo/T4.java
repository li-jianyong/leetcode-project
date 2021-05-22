package com.springbatch.demo;

import org.junit.Test;

/**
 * 最大利润
 */
public class T4 {
    // [7,3,5,1,4]
    public int maxProfit(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        // 维持持股和不持股状态!!!~~~~~~
        int[][] dp = new int[len][2];
        dp[0][0]=0;
        dp[0][1]=-nums[0];
        for (int i=1;i<len;i++){
            // 第i天的不持股的状态，前一天不持股，昨天持股加上今天的卖出收益
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + nums[i]);
            // 上一天买入，和今天买入的最大
            dp[i][1] = Math.max(dp[i-1][1],-nums[i]);
        }
        return dp[len-1][0];
    }

    @Test
    public void test(){
        int[] nums = {1,5,6,1,4};
        System.out.println(maxProfit(nums));
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("当前核心线程数量" +nThreads);
    }

}

package com.springbatch.demo.leetcode;

/** 746. 使用最小花费爬楼梯
 * @author: lijianyong
 * @since: 2021/7/11 17:56
 */
public class T746 {
    /*第i级台阶是第i-1级台阶的阶梯顶部。
    * 踏上第i级台阶花费cost[i]，直接迈一大步跨过而不踏上去则不用花费
    * */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] minCost = new int[len];
        minCost[0] = 0;
        minCost[1] = Math.min(cost[0],cost[1]);
        for (int i=2;i<len;i++) {
            minCost[i] = Math.min(minCost[i-1] + cost[i],minCost[i-2] + cost[i-1]);
        }
        return minCost[len-1];
    }
}

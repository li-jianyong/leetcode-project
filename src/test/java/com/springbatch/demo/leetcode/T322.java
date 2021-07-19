package com.springbatch.demo.leetcode;

import java.util.Arrays;

/**
 *
 */
public class T322 {
    int res = Integer.MAX_VALUE;
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount];
        return findWay(coins,amount);
    }

    /** 计算coins数组里，能够凑出amount来
     * @param coins
     * @param amount
     * @return 返回数量
     */
    public int findWay(int[] coins,int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo[amount-1] != 0) {
            return memo[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for (int i=0;i<coins.length;i++) {
            int res = findWay(coins,amount-coins[i]);
            if (res >= 0 && res < min) {
                min = res+1;
            }
        }
        memo[amount-1] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount-1];
    }
    // 方法2 凑零钱类似背包问题，遍历包的质量，再遍历物品价值，遍历钱的数量，再遍历最小钱币数
    public int coinChange2(int[] coins,int amount) {
        if (coins.length == 0) {
            return -1;
        }
        int[] memo = new int[amount+1];
        Arrays.fill(memo,amount+1);
        memo[0] = 0;
        for (int i=1;i<=amount;i++) {
            for (int j=0;j<coins.length;j++) {
                if (i-coins[j] > 0) {
                    // 不包含当前coins[j]，和包含当前coins[j]的两种情形
                    memo[i] = Math.min(memo[i],memo[i-coins[j]] + 1);
                }
            }
        }
        return memo[amount] == (amount+1) ? -1 : memo[amount];
    }
}

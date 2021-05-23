package com.springbatch.demo.leetcode;

/**
 * 黑板抑或，博弈论类型题目，判断先后还是后手获取胜利
 */
public class T810 {
    public boolean xorGame(int[] nums) {
        int sum = 0;
        for (int i: nums) sum ^= i;
        return sum == 0 || nums.length % 2 == 0;
    }
}

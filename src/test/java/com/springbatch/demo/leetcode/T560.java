package com.springbatch.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 连续子数组和为K的数组个数
 */
public class T560 {
    public int subarraySum(int[] nums,int k) {
        int count = 0;
        int len = nums.length;
        for (int left = 0;left < len;left++) {
            // 固定左边界
            int sum = 0;
            for (int right = left;right < len;right++) {
                // 从左边开始一直统计到末尾，计算可能出现的次数，有可能存在抵消的情形，所以一直走到末尾
                sum += nums[right];
                if (sum == k) count++;
            }
        }
        return count;
    }
    // 方法2 前缀和数组 o(n^2)解法
    public int subarraySum2(int[] nums,int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len+1];
        preSum[0] = 0;
        for (int i=0;i<len;i++) {
            // i+1位置的前缀和等于i位置的前缀和加上i位置的值；
            preSum[i+1] = preSum[i] + nums[i];
        }
        int count =0;
        for (int left = 0;left<len;left++) {
            for (int right = left;right < len;right++) {
                if (preSum[right+1] - preSum[left] == k) {
                    // 代表right+1位置和left之间的差是K，那么是个连续的
                    count++;
                }
            }
        }
        return count;
    }
    // 方法3  前缀和 + 哈希优化
    public int subarraySum3(int[] nums,int k) {
        Map<Integer,Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0,1);
        int preSum = 0,count=0;
        for (int num : nums) {
            preSum += num;
            // 当前前缀和preSum 如果历史map里存在preSum-k前缀和，那么则找到了满足条件的地方。
            if (preSumFreq.containsKey(preSum - k)) count += preSumFreq.get(preSum - k);
            preSumFreq.put(preSum,preSumFreq.getOrDefault(preSum,0) + 1);
        }
        return count;
    }
}

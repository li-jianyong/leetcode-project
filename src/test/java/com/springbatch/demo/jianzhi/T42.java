package com.springbatch.demo.jianzhi;

/**
 * 连续子数组的最大和
 */
public class T42 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cur = nums[0];
        int greatest = nums[0];
        for (int i=1;i<nums.length;i++) {
            if (cur < 0) {
                cur = nums[i];
            } else {
                cur += nums[i];
            }
            if (greatest < cur) {
                greatest = cur;
            }
        }
        return greatest;
    }
}

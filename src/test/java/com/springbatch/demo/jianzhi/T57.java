package com.springbatch.demo.jianzhi;

/**
 * 两个数字和为s,找出这两个数字
 */
public class T57 {
    // 双指针对撞，
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(true) {
            if (nums[i] + nums[j] == target) {
                return new int[]{nums[i],nums[j]};
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
    }
}

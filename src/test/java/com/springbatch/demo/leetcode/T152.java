package com.springbatch.demo.leetcode;

public class T152 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i=0;i<nums.length;i++) {
            // 如果当前元素值小于0，将imax和imin进行交换
            if (nums[i] <0 ) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax*nums[i],nums[i]);
            imin = Math.min(imax*nums[i],nums[i]);
            max = Math.max(max,imax);
        }
        return max;
    }

}

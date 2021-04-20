package com.springbatch.demo.mianshi;

/**
 * @ClassName:T53
 * @author: Administrator
 * @Date: 2020/10/21 10 11
 **/
public class T53 {
    // 二分法找到左边界和右边界 给定值不包含边界值
    public int search(int[] nums,int target) {
        int i=0,j=nums.length-1;
        while(i<j) {
            int m = (i+j)/2;
            if (nums[m] <= target) i = m+1;
            else j = m-1;
        }
        int right = i;
        // 数组里无target,提前返回
        if(j>=0 && nums[j] != target) return 0;
        // 搜索左边界right
        i=0;
        j=nums.length-1;
        while(i<=j) {
            int m = (i+j)/2;
            if (nums[m] < target) i = m+1;
            else j = m-1;
        }
        int left = j;
        return right-left-1;
    }
    // 优化思路，两次都寻找target右边界 == target有边界和target-1的左边界
    public int search1(int[] nums,int target) {
        return helper(nums,target) - helper(nums,target-1);
    }
    public int helper(int[] nums,int tar) {
        int i =0,j=nums.length -1;
        while(i<=j) {
            int m = (i+j)/2;
            if(nums[m] < tar) i = m+1;
            else j = m-1;
        }
        return i;
    }
}

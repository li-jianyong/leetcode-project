package com.springbatch.demo.leetcode;

import java.util.Arrays;

/**
 * @ClassName:T22
 * @author: Administrator
 * @Date: 2020/10/9 10 32
 **/

public class T21 {
    public void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int[] exchange(int[] nums) {

        int len = nums.length;
        if (len == 1) return nums;
        // 定义双指针i，j向中间靠拢，到i>j所有的元素都遍历到了
        int i =0,j=len-1;
        while(i<=j) {
            while((nums[i]&1) == 1) {
                i++;
            }
            while((nums[j]&1)==0) {
                j--;
            }
            swap(nums,i,j);
            i++;
            j--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] exchange = new T21().exchange(arr);
        System.out.println(Arrays.toString(exchange));
    }
}


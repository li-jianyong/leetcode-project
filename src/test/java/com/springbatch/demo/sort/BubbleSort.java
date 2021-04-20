package com.springbatch.demo.sort;

public class BubbleSort {

    public static int[] bubbleSort(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            // 冒泡排序每次确定好最大数字的位置
            for (int j=0;j<nums.length-1-i;j++) {
                if (nums[j+1]<nums[j]) {
                    swap(nums,j+1,j);
                }
            }
        }
        return nums;
    }
    private static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

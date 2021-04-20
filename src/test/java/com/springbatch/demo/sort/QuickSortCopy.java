package com.springbatch.demo.sort;

public class QuickSortCopy {
    public int[] quickSort(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    void quickSort(int[] nums,int low,int high) {
        if (low < high) {
            int pivot = partition(nums,low,high);
            quickSort(nums,low,pivot-1);
            quickSort(nums,pivot+1,high);
        }
    }
    int partition(int[] nums,int low,int high) {
        int temp = nums[low];
        while(low < high) {
            while(low < high && nums[high] >= temp) high--;
            nums[low] = nums[high];
            while(low < high && nums[low] <= temp) low++;
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }
}

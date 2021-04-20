package com.springbatch.demo.sort;

public class MergeSortCopy {
    int[] mergeSort(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    void mergeSort(int[] nums,int start,int end) {
        if (start < end) {
            int mid = start + (end - start) >> 1 ;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }
    void merge(int[] nums,int start,int mid,int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[end - start + 1];
        int count = 0;
        while(i<=mid&&j<=end) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                count += mid - i + 1;
                temp[k++] = nums[j++];
            }
        }
        while(i<=mid) {
            temp[k++] = nums[i++];
        }
        while(j<=end) {
            temp[k++] = nums[j++];
        }
        for (int m=0;m<end-start+1;m++) {
            nums[start+m] = temp[m];
        }
    }
}

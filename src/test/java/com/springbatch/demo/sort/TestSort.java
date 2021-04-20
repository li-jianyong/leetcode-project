package com.springbatch.demo.sort;

public class TestSort {

    /** 冒泡排序
     * @param nums
     */
    public int[] bubbleSort(int[] nums) {
        // 比较次数 nums.lenght-1次
        for(int i=0;i<nums.length-1;i++) {
            for (int j=0;j<nums.length-1-i;j++) {
                if (nums[j+1]<nums[j]) swap(nums,i,j);
            }
        }
        return nums;
    }

    /** 插入排序
     * @param nums
     * @return
     */
    public int[] insertSort(int[] nums) {
        for (int i=1;i<nums.length-1;i++) {
            for (int j=i;j>0;j--) {
                if (nums[j] < nums[j-1]) swap(nums,j,j-1);
            }
        }
        return nums;
    }

    /** 快速排序
     * @param nums
     * @return
     */
    public int[] quickSort(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    void quickSort(int[] nums,int low,int high) {
        if (low < high) {
            int index = partition(nums,low,high);
            quickSort(nums,low,index-1);
            quickSort(nums,index,high);
        }
    }
    int partition(int[] nums,int left,int right) {
        int pivot = nums[left];
        while (left < right) {
            // 从右侧开始
            while(left<right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while(left<right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
    /** 归并排序
     * @param nums
     * @return
     */
    public int[] mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public void mergeSort(int[] nums,int left,int right) {
        if (left < right) {
            int mid = left + (right - left ) >> 1;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }
    void merge(int[] nums,int left,int mid,int right) {
        int i = left;
        int j = mid;
        int[] temp = new int[right-left+1];
        int k=0;
        while(i <= mid && j <= right) {
            if (nums[i]<nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i<=mid) temp[k++] = nums[i++];
        while (j<=right) temp[k++] = nums[i++];
        // 最后将辅助数组的值放回到nums原数组里。
        for (int m = 0;m < right-left+1;m++) {
            nums[left+m] = temp[m];
        }
    }
    void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j] = temp;
    }
}

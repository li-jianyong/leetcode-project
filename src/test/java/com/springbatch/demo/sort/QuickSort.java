package com.springbatch.demo.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    Random rand = new Random();
    @Test
    public void test(){
        QuickSort quickSort = new QuickSort();
        int[] arr = {2,4,1,8,2,4,6};
        quickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public int[] quickSort(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    void quickSort(int[] nums,int low,int high) {
        if (low < high) {
            int index = partition2(nums,low,high);
            quickSort(nums,low,index-1);
            quickSort(nums,index+1,high);
        }
    }

    /** partition过程，找到关键位置的索引下标，选择partition的时候每次都以首位为基准，这样可能因素样本差异，导致性能退化到n^2
     * @param nums
     * @param low
     * @param high
     * @return
     */
    int partition(int[] nums,int low,int high) {
        // 1，左边定基准，从右边开始扫描
        int temp = nums[low];
        while(low < high) {
            // 1.1从高位开始判断
            while(low<high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high];
            while(low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
        }
        //将最初的temp值还原给低位；
        nums[low] = temp;
        return low;
    }

    /** partition过程可以换一种写法
     * @param nums
     * @param low
     * @param high
     * @return
     */
    int partition2(int[] nums,int low,int high) {
        int i = low,j = high + 1;

//        int temp = selectPivotRandom(nums,low,high);
        int temp = SelectPivotMedianOfThree(nums,low,high);
        while(true) {
            while(nums[++i] < temp && i<high);
            while(nums[--j] > temp);

            if(i >= j) break;
            swap(nums,i,j);
        }
        // 跳出循环，这时候，i>=j,最后j停下来的位置数值是小于temp的，i位置是大于temp,所以将j位置和low交换，
        nums[low]= nums[j];
        nums[j]=temp;
        return j;
    }
    //1, 选择基准方式
    int selectPivotRandom(int[] nums,int low,int high){
        int pivotIndex =  rand.nextInt(high-low) + low;
        swap(nums,low,pivotIndex);
        return nums[low];
    }
    //2,三数取中（median-of-three）(优化有序的数据)
    int SelectPivotMedianOfThree(int[] nums,int low,int high) {
        int mid = low + (high - low) >> 1;
        // 如果中间位置大于最右边，则交换，让大的在最右，
        if (nums[mid] > nums[high]) {
            swap(nums,mid,high);
        }
        // 如果左边大于右边，那继续交换，保证右边的元素最大
        if (nums[low] > nums[high]) {
            swap(nums,low,high);
        }
        // 最后比较左边和中间位置的大小，如果中间大，则交换，保证 左 < 中 < 右
        if (nums[mid] > nums[low]) {
            swap(nums,mid,low);
        }
        // 最后左侧的值是第二大，毕竟左侧的数作为基准数要作为基准出现
        return nums[low];
    }
    void swap(int[] nums,int low,int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}

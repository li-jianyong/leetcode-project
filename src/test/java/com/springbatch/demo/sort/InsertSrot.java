package com.springbatch.demo.sort;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * 插入排序 稳定排序 时间复杂度n^2
 */
public class InsertSrot {
    public int[] insertSort(int[] nums) {
        // 插入排序首先排好第一个位置的元素，然后依次排后面的元素，从i=1开始往后，小于前面则交换；
        for (int i=1;i<nums.length;i++) {
            // 当前元素依次向前比较
            for (int j=i;j>0;j--) {
                // 相等的时候，不进行交换，所以插入排序是稳定排序
                if (nums[j] <nums[j-1]) {
                    // 如果比前面的值小，就交换
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
    public int[] insertSort2(int[] nums) {
        for (int i=1;i<nums.length;i++) {
            int temp = nums[i];
            int j;
            for (j=i;j>0&&nums[j-1]>temp;j--) {
                nums[j] = nums[j-1];
            }
            nums[j] = temp;
        }
        return nums;
    }
    void insertSort(int[] nums,int low,int high) {
        for (int i=low+1;i<=high;i++) {
            for (int j = i;j>0;j--) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j-1];
                    nums[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,4};
        InsertSrot insertSrot = new InsertSrot();
        insertSrot.insertSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        LocalDate ld = LocalDate.now();
    }
}

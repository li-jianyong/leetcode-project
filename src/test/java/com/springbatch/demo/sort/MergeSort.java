package com.springbatch.demo.sort;

import org.junit.Test;

import java.util.Arrays;

/** 归并排序写法
 * @ClassName:MergeSort
 * @author: Administrator
 * @Date: 2020/12/29 22 14
 **/
public class MergeSort {
    /** 递归写法
     * @param nums
     * @param start 起始位置
     * @param end 结束位置
     */
    private void mergeSort(int[] nums,int start,int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }
    private void merge(int[] nums,int start,int mid,int end) {
        int i = start;
        int j = mid + 1;
        int[] temp = new int[end-start+1];
        int k = 0;
        // 用来统计逆序对数
        int count = 0;
        while (i<=mid&&j<=end) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                // 在右侧元素出列的时候，当前元素的到mid位置之间的所有元素都将与当前左侧元素够成逆序对
                // 这个时候是统计逆序对的时机，也是归并排序的经典处理这个过程的方法
                count += mid-i+1;
                temp[k++] = nums[j++];
            }
        }
        while (i<=mid) {
            temp[k++] = nums[i++];
        }
        while(j<=end) {

            temp[k++] = nums[j++];
        }
        // 最后将辅助数组的值放回到nums原数组里。
        for (int m = 0;m<end-start+1;m++) {
            nums[start+m] = temp[m];
        }

    }
    @Test
    public void t(){
     int[] arr = {3,2,4,5};
         mergeSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}

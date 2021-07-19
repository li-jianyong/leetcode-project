package com.springbatch.demo.jianzhi;

import java.util.ArrayList;
import java.util.List;

/** 旋转排序数组
 * @author: lijianyong
 * @since: 2021/6/15 22:50
 */
public class T189 {
    public void rotate(int[] nums,int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        List<Integer> arr = new ArrayList<>();
        int[] res = arr.stream().mapToInt(Integer::valueOf).toArray();
    }
    public void reverse(int[] nums,int start,int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}

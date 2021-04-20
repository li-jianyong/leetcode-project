package com.springbatch.demo.leetcode;

/** 旋转数组最小值
 * @ClassName:T9
 * @author: Administrator
 * @Date: 2020/12/31 17 49
 **/
public class T9 {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        if (len ==0) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (numbers[mid] > numbers[right]) {
                // 最小数字一定在mid后边
                left = mid +1;
            } else if(numbers[mid] == numbers[right]) {
                // 只能排除掉right位置
                right = right-1;
            } else {
                right = mid;
            }
        }
        return numbers[left];
    }
    // 更简洁代码
    private int minArray(int[] nums,int left,int right) {
        if (left + 1 > right) {
            return Math.min(nums[left],nums[right]);
        }
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        int mid = left + (right-left)/2;
        return Math.min(minArray(nums,left,mid-1),minArray(nums,mid,right));
    }
}

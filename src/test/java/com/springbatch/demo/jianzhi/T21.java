package com.springbatch.demo.jianzhi;

/** 数组位置调整，将奇数都放在前面，偶数放在后面
 * @ClassName:T21
 * @author: Administrator
 * @Date: 2021/1/1 15 40
 **/
public class T21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length==0) return null;
        int len = nums.length;
        if (len == 1) return nums;
        int i=0,j=len-1;
        while (i<j) {
            if ((nums[i] & 1 ) != 0) {
                i++;
                continue;
            }
            if ((nums[j] & 1) == 0 ) {
                j--;
                continue;
            }
            swap(nums,i++,j--);
        }
        return nums;
    }
    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

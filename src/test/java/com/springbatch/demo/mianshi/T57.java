package com.springbatch.demo.mianshi;

/** 对撞双指针 一般相遇时退出循环
 * @ClassName:T57
 * @author: Administrator
 * @Date: 2020/10/21 15 58
 **/
public class T57 {
    // 解法 对撞双指针，
    public int[] twoSum(int[] nums,int target) {
        int i=0,j=nums.length-1;
        while(i<j) {
            int s = nums[i] + nums[j];
            if (s < target) {
                i++;
            } else if(s > target) j--;
            else return new int[] {nums[i],nums[j]};
        }
        return new int[0];
    }
}

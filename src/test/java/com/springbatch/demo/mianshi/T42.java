package com.springbatch.demo.mianshi;

/**
 * @ClassName:T42
 * @author: Administrator
 * @Date: 2020/10/19 19 59
 **/
public class T42 {
    // nums[i] 保存以i结尾的连续子数组最大和
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i=1;i<nums.length;i++) {
            // 将每个元素改成该元素结尾的最大值 如果i-1是负数的话，就累加0；
            nums[i] += Math.max(nums[i-1],0);
            res = Math.max(res,nums[i]);
        }
        return res;
    }
}

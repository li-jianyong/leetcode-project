package com.springbatch.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 三数之和
 * @ClassName:T15
 * @author: Administrator
 * @Date: 2020/12/5 17 26
 **/
public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先对基础样本进行排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k=0;k<nums.length-2;k++) {
            // 排序后，如果第一位元素大于0，那么不可能有三位相加和为0的情况，直接推出
            if(nums[k] > 0) break;
            // 去重，如果两个元素一样的话，直接遍历下一个元素K
            if(k > 0 && nums[k] == nums[k-1]) continue;
            int i = k+1,j=nums.length-1;
            // 内层遍历两位数，因为排好序，按照中心靠拢搜索；重复值跳过
            while(i<j) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0) {
                    // 遇到重复值则直接跳过
                    while(i<j && nums[i] == nums[++i]);
                } else if (sum >0) {
                    while(i<j && nums[j] == nums[--j]);
                } else {
                    // 搜索到答案，然后添加到结果集保存！
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
                    while(i<j && nums[i] == nums[++i]);
                    while(i<j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}

package com.springbatch.demo.leetcode;

/**
 * 优美子数组
 */
public class T1248 {
    // 前缀和写法
    public int numberOfSubarrays(int[] nums, int k) {
        // 当前前缀和（奇数的个数） 值是前缀和的个数
        int[] prefixSum = new int[nums.length+1];
        // 前缀和为0 奇数个数为0 的个数是0
        prefixSum[0] = 1;
        int res = 0,sum=0;
        for (int num:nums) {
            // 如果是奇数，那么sum+1,然后前缀和奇数个为1的个数加1；如果偶数，那么前缀和奇数个数为0的 前缀和个数+1
            sum += num&1;
            prefixSum[sum]++;
            // 每次判断当前奇数个数即前缀和 大于等于K的时候，进行统计，次数是前面个数是sum-k对应的前缀和个数
            // 当前位置一共sum个奇数，sum-k位置一共sum-k个奇数，那么sum-k到sum之间就是k个奇数，正好统计进来，此时也形成了窗口
            if (sum >= k) res += prefixSum[sum-k];
        }
        return res;
    }
}

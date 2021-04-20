package com.springbatch.demo.jianzhi;

/**
 * 数组里两个不相同的数字
 */
public class T56_1 {
    public int[] singleNumbers(int[] nums) {
        int k = 0;
        // 最后的结果
        for (int num:nums) {
            k ^= num;
        }
        // 获取最低为的1,由两个不同的数字异或的结果而成，那么mask这个位置来说，肯定一个是1一个是0，那么就根据这个规则进行分组异或，一定将这两个数字分开
        int mask = 1;
        while(( k & mask) == 0) {
            mask <<= 1;
        }
        int a=0,b=0;
        for (int num:nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }
}

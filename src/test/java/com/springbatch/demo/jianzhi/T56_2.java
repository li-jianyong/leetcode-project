package com.springbatch.demo.jianzhi;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:T56_2
 * @author: Administrator
 * @Date: 2020/10/26 20 00
 **/
public class T56_2 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }
    @Test
    public void t(){
        int[] arr = {1,2,1,1,2,2,3};
        int i = singleNumber(arr);
        System.out.println(i);
    }
    // 数电算法2 有限状态自动机 看不懂
    public int singleNumber1(int[] nums) {
        int ones = 0,twos = 0;
        for (int num:nums) {
            ones = ones ^ num  & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
    // 方法3 二进制运算
    public int singleNumber3(int[] nums) {
        int[] counts = new int[32];
        for (int num:nums) {
            // num数字，作32次与运算，将二进制的1全部映射到数组里
            for (int j =0;j<32;j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res=0,m=3;
        // 遍历数组 将每一位的数字取余，起始类似两个数字异或为0的思想，三个数字一样那么二进制位对应的数字都是3的倍数，因此可以延申到5，7之类的数字；
        for(int i=0;i<32;i++) {
            res <<= 1;
            // 从数组的末尾开始算，高位的数字
            res |= counts[31-i] % m;
        }
        return res;
    }
}

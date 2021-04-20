package com.springbatch.demo.jianzhi;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/** 原题为最小，这里换成了最大。熟悉代码
 * 返回一个有整型数组组成的能够拼接出来的最大字符串
 */
public class T45 {
    public String maxNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        int len = nums.length;
        String[] str = new String[len];
        StringBuilder res = new StringBuilder();
        for (int i=0;i<len;i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c2.compareTo(c1);
            }
        });
        for (String tmp : str) {
            res.append(tmp);
        }
        return res.toString();
    }
    @Test
    public void test(){
        int[] arr = {3,4,5,62,32,10};
        System.out.println(maxNumber(arr));
    }
}

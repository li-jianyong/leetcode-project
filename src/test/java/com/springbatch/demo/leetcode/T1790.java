package com.springbatch.demo.leetcode;

import org.junit.Test;

/**
 * 仅一次交换能够完成的 两个字符串相等
 */
public class T1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        String temp1 = "",temp2 = "";
        int len1 = s1.length();
        for(int i=0;i<len1;i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                temp1 += String.valueOf(s1.charAt(i));
                temp2 = s2.charAt(i) + temp2;
            }
            if (temp1.length() > 2) return false;
        }
        return (temp1.length() == 2) && (temp1.equals(temp2));
    }
    @Test
    public void test(){
        boolean b = areAlmostEqual("baaa", "abbb");
        System.out.println(b);
    }
}

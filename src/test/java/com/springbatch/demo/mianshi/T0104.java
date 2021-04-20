package com.springbatch.demo.mianshi;

public class T0104 {
    /** 判断字符串是否为某一个回文序列的重排序组合
     * @param s
     * @return
     */
    boolean canPermutePalindrome(String s){
        int[] a = new int[128];
        int i, cnt = 0, len = s.length();

        for (i = 0; i < len; i++)
            a[s.charAt(i)]++;
        for (i = 0; i < 128; i++) {
            if (a[i]%2 == 1)
                cnt++;
            if (cnt >= 2)
                return false;
        }
        return true;
    }
}

package com.springbatch.demo.mianshi;

/**
 * @ClassName:T50
 * @author: Administrator
 * @Date: 2020/10/20 21 24
 **/
public class T50 {
    public char firstUniqueChar(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c-'a']++;
        }
        for (char c : chars) {
            if (count[c]==1) {
                return c;
            }
        }
        return ' ';
    }
}

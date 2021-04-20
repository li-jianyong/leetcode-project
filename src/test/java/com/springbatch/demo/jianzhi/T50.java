package com.springbatch.demo.jianzhi;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 返回第一个次数为1的字符
 */
public class T50 {
    public char firstUniqChar(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++) {
            char tmp = s.charAt(i);
            map.put(tmp,map.getOrDefault(tmp,0) + 1);
        }
        for(Character key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }
        return ' ';
    }
    // 方法2 不用count计数，直接采用boolean值判断
    public char firstUniqChar2(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (char c :array) {
            map.put(c,!map.containsKey(c));
        }
        for (char c : array) {
            if (map.get(c)) return c;
        }
        return ' ';
    }
    // 方法3 基于数组实现
    public char firstUniqChar3(String s) {
        // 26个字母
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        // 每个字母找各自的坑位，计数
        for (char ch : chars){
            arr[ch -'a'] ++;
        }
        // 最后遍历数组
        for (char c:chars){
            if (arr[c-'a'] == 1){
                return c;
            }
        }
        return ' ';
    }
    @Test
    public void test(){
        String a = "leetcode";
        System.out.println(firstUniqChar(a));
        System.out.println();
    }
}

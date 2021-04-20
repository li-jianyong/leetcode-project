package com.springbatch.demo.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不重复子串
 */
public class T48 {
    public int lengthOfLargestSubstring(String s) {
        // 存储所有的字符及其位置
        Map<Character,Integer> dic = new HashMap<>();
        int i = -1,res=0;
        for (int j=0;j<s.length();j++){
            // 如果hash里包含该字符，说明当前字符已经重复了，那么需要更新起始位置为当前重复的字符位置
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i,dic.get(s.charAt(j)));
            }
            // 字符的位置存起来
            dic.put(s.charAt(j),j);
            res = Math.max(res,j-i);
        }
        return res;
    }
    // 方法2 滑动窗口
    public int lengthOfLargestSubstring2(String s) {
        if (s == null) return 0;
        int max = 0,start = -1;
        // 使用哈希表 存储各字符最后一次出现的位置
        HashMap<Character,Integer> dic = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            char tmp = s.charAt(i);
            // 判断窗口是不是要更新
            if (dic.containsKey(tmp)) start = Math.max(start,dic.get(tmp));
            dic.put(tmp,i);
            max = Math.max(max,i-start);
        }
        return max;
    }

}

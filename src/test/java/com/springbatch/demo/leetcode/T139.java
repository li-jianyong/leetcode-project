package com.springbatch.demo.leetcode;

import java.util.List;

/** 单词拆分 完全背包问题
 * @author: lijianyong
 * @since: 2021/7/11 8:58
 */
public class T139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[]数组，表示第i个位置的长度的串能够0-i位置的长度的串能够被字符串数组表示
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 截取从j到i位置，看是否包含
                // 递推，如果j-i位置元素能够被包含进来，而且第j位置有效，那么当前i位置是可以的
                if (wordDict.contains(s.substring(j, i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }
        return valid[s.length()];
    }
}

package com.springbatch.demo.leetcode;

/**
 * 最长回文子串
 */
public class T5 {
    // 方法1，暴力解法，判断每段长度
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // 方法2 动态规划
    public String longestPalindrome2(String s) {
        // 特判
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1,begin = 0;
        // dp[i][ij] 表示S[i,j]是否为回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        for (int i=0;i<len;i++) {
            dp[i][i]=true;
        }
        for (int j=1;j<len;j++) {
            for (int i=0;i<j;i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    // 如果charArray[i]==charArray[j]
                    if (j-i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                // 只要当前的回文串 大于最大长度，则记录长度和起始位置
                if (dp[i][j] && j-i+1>maxLen) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    // 方法3 中心扩散法
    public String longestPalindrome3(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1;
        String res = s.substring(0,1);
        for (int i=0;i<len-2;i++) {
            String oddStr = centerSpread(s,i,i);
            String evenStr = centerSpread(s,i,i+1);
            String maxStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxStr.length() > maxLen) {
                maxLen = maxStr.length();
                res = maxStr;
            }
        }
        return res;
    }
    private String centerSpread(String s,int left,int right) {
        int len =  s.length();
        int i = left;
        int j =right;
        while(i>=0 && j<len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i+1,j);
    }
}

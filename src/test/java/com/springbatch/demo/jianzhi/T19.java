package com.springbatch.demo.jianzhi;

/**
 * @ClassName:T10
 * @author: Administrator
 * @Date: 2020/10/8 10 31
 **/
public class T19 {
    public boolean isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();
        // 动态规划选择多一个长度
        boolean[][] f = new boolean[n + 1][m + 1];
        // 遍历过程填满f的值
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看 因为可以匹配多个，所以主串可以再往前移动，匹配串不动即可
                        // i>=1 && j>=2防止越界 主串的前一个和匹配串的前两个
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
    // 递归思路“
    public boolean isMathch1(String A,String B) {
        if (A.length() == 0) {
            if (B.length()%2 != 0) return false;
            int i = 1;
            // 偶数位置必须为*
            while(i < B.length()) {
                if (B.charAt(i) != '*') return false;
                i += 2;
            }
            return true;
        }
        if (B.length() > 1) {
            return false;
        }
        // c3代表正则串的下一位，存在则更新
        char c1 = A.charAt(0),c2 = B.charAt(0),c3 = 'a';
        if(B.length() > 1) {
            c3 = B.charAt(1);
        }
        if (c3 != '*') {
            if (c1 == c2 || c2 == '.') {
                return isMathch1(A.substring(1),B.substring(1));
            } else {
                return false;
            }
        } else {
            // 如果该位字符一样，或是正则串该位是 '.'，和dp一样，有看和不看两种情况
            if (c1 == c2 || c2 == '.') {
                return isMathch1(A.substring(1),B) || isMathch1(A,B.substring(2));
            } else {
                // 不一样，那么正则串这两位就废了，直接往后走
                return isMathch1(A,B.substring(2));
            }
        }
    }
}

package com.springbatch.demo.jianzhi;

/**
 * 数字翻译成字符串的多少种方法
 */
public class T46 {
    /* 对于任意一个数字有两种考虑，只翻译自己和后面的数字组合起来，组合翻译，前提是数字是10-25之间
    * 动态规划解法 dp(i)前i个数字的翻译方法数，
    *   都是单个翻译 12345 和1234种数一样都是1 因为都只能单个翻译
    * */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1,b=1;
        for (int i=2;i<s.length();i++) {
            String tmp = s.substring(i-2,i);
            // 如果属于[10,25]之间返回dp[i-2]+dp[i-1] 否则，返回dp[i-1]
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25")<=0 ? a+b : a;
            b = a;
            a = c;
        }
        return a;
    }
    public int translateNum2(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length()+1];
        dp[0]=dp[1]=1;
        for (int i=2;i<=s.length();i++) {
            String tmp = s.substring(i-2,i);
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25")<=0) {
                dp[i] = dp[i-2] + dp[i-1];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];
    }
}

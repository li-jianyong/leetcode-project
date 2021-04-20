package com.springbatch.demo.mianshi;

/**
 * @ClassName:T58_2
 * @author: Administrator
 * @Date: 2020/10/21 20 11
 **/
public class T58_2 {
    // 方案1 超时
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
    public String reverseLeftWords1(String s,int n) {
        StringBuilder res = new StringBuilder();
        for (int i=n;i<s.length();i++) {
            res.append(s.charAt(i));
        }
        for (int i=0;i<n;i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }
    public String reverseLeftWords2(String s,int n) {
        String res = "";
        for (int i= n;i<n+s.length();i++) {
            res += s.charAt(i%s.length());
        }
        return res;
    }
}

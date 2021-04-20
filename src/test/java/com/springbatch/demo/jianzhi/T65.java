package com.springbatch.demo.jianzhi;

/**
 * 使用位运算，实现加法操作
 */
public class T65 {
    public int add(int a,int b) {
        while(b!=0) {
            int c = (a&b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}

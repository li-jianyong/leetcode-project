package com.springbatch.demo.mianshi;

/**
 * @ClassName:T65
 * @author: Administrator
 * @Date: 2020/10/26 19 09
 **/
public class T65 {
    // 二进制实现加法
    public int add(int a,int b) {
        while(b!=0){
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}

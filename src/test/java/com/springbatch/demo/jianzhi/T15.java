package com.springbatch.demo.jianzhi;

/** 二进制中1的个数
 * @ClassName:T10
 * @author: Administrator
 * @Date: 2020/10/8 10 31
 **/
public class T15 {
    // 剑指offer 15
    /*
    * 根据 与运算 定义，设二进制数字 nn ，则有：
        若 n \& 1 = 0n&1=0 ，则 nn 二进制 最右一位 为 00 ；
        若 n \& 1 = 1n&1=1 ，则 nn 二进制 最右一位 为 11
    * */
    public int hammingWeight(int n) {
        int res=0;
        while (n!=0) {
            res += n&1;
            n >>>= 1;
        }
        return res;
    }
    // n&n-1的巧用
    public int hammingWeight1(int n) {
        int res=0;
        while(n!=0) {
            res++;
            n &= (n-1);
        }
        return res;
    }
}

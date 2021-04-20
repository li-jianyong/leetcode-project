package com.springbatch.demo.jianzhi;

/**  数值的整数次方
 * @ClassName:T10
 * @author: Administrator
 * @Date: 2020/10/8 10 31
 **/
public class T16 {
    public double myPow(int x,int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}

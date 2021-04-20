package com.springbatch.demo.jianzhi;

/** 1~N 连续整数1出现的次数统计
 * @ClassName:T43
 * @author: Administrator
 * @Date: 2021/1/2 15 13
 **/
public class T43 {
    public int countDigitOne(int n) {
        return f(n);
    }
    private int f(int n) {
        if (n <= 0) {
            return 0;
        }
        String s = String.valueOf(n);
        // 算出三个位置的值，第一位数字大小，第二位位数pow，last剩下的数字
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10,s.length() -1);
        int last = n - pow * high;
        if (high == 1) return f(pow-1) + last + 1 + f(last);
        else return pow + high*f(pow-1) + f(last);
    }
}

package com.springbatch.demo.jianzhi;

/** 数字连续出现，第n位置对应的数字
 * @ClassName:T44
 * @author: Administrator
 * @Date: 2021/1/2 16 18
 **/
public class T44 {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 9  90 900 9000
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // start当前数字的开始部分，类似10，100，1000这样的数字 然后除以位数取整相加num，求出来最后的位置位于num这个数字。
        long num = start + (n - 1) / digit; // 2.
        // 拿到数字之后，转成字符，算出与位数取余后的位置，
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

}

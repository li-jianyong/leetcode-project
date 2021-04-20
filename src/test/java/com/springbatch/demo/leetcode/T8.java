package com.springbatch.demo.leetcode;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

/**
 * @ClassName:T8
 * @author: Administrator
 * @Date: 2020/12/5 10 28
 **/
public class T8 {
    @Test
    public void t(){
        String parm = "42";
       int a = myAtoi(parm);
        System.out.println(a);
    }

    public int myAtoi(String str) {
        int len = str.length();
        char[] charArray = str.toCharArray();
        int index =0;
        while(index < len && charArray[index] == ' ') {
            index++;
        }
        // 如果index值来到了最后，代表全部是空格
        if (index == len) {
            return 0;
        }
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        }else if(firstChar == '-') {
            index++;
            sign=-1;
        }
        int res = 0;
        while(index < len) {
            char currChar = charArray[index];
            if (currChar > '9' || currChar < '0') break;
            // res*10后直接越界 或者 res乘以10等于最大数除以10，看个位数加入后是否越界，个位数大于最大数的个位数则越界
            if (res > Integer.MAX_VALUE /10 || (res == Integer.MAX_VALUE / 10 && (currChar -'0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if(res < Integer.MIN_VALUE /10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res*10 + sign*(currChar - '0');
            index++;
        }
        return res;
    }

}

package com.springbatch.demo.test1;

import java.util.HashMap;
import java.util.Map;

public class T4 {
    String getCircleNumber(long num1,long num2) {
        // 记录整数部分
        long a = num1/num2;
        // 第一次余数，作为第二次的num1，继续开始除
        num1 = num1 - a*num2;
        String res = "";
        // leftIndex循环小数部分的开始位置，idx当前商在小数部分的位置
        int leftIndex = -1,idx = 0;
        Map<Long,Integer> memo = new HashMap<>();
        // 没除尽
        while (num1 != 0) {
            num1 = num1 * 10;
            // 说明有重复的余数出现
            if (memo.containsKey(num1)) {
                leftIndex = memo.get(num1);
                break;
            }
            memo.put(num1,idx);
            long temp = num1 / num2;
            res = res + temp;
            // 继续算出下一个num1
            num1 = num1 - temp * num2;
            idx++;
        }
        if (leftIndex != -1) {
            // 有循环小数
            return a + "." + res.substring(0,leftIndex) + "(" + res.substring(leftIndex) + ")";
        } else {
            // 无循环小数
            return res == "" ? a+"" : a + "." + res;
        }

    }
}

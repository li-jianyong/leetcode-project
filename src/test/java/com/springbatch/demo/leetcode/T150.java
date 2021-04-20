package com.springbatch.demo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 逆波兰数求值
 */
public class T150 {
    /** 双栈思路，数字栈，运算符栈
     * @param tokens 符号数组
     * @return
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> d = new ArrayDeque<>();
        for (String s : tokens) {
            if ("+-*/".contains(s)) {
                int b = d.pollLast(),a = d.pollLast();
                d.addLast(calc(a,b,s));
            } else {
                d.addLast(Integer.parseInt(s));
            }
        }
        return d.pollLast();
    }
    int calc(int a,int b,String op) {
        if (op.equals("+")) return a+b;
        else if (op.equals("-")) return a-b;
        else if (op.equals("*")) return a*b;
        else if (op.equals("/")) return a/b;
        else return -1;
    }
}

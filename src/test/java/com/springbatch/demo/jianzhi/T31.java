package com.springbatch.demo.jianzhi;

import java.util.Stack;

/**
 * 判断栈的入队出队顺序是否满足栈的结构
 * 每次将栈的元素入栈，然后每次遍历都去判断栈里的元素是否和出战序列是否相等，相等则出栈；
 */
public class T31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}

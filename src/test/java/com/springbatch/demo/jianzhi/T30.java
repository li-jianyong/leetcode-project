package com.springbatch.demo.jianzhi;

import java.util.Stack;

/** 包含min函数的栈
 * @ClassName:T30
 * @author: Administrator
 * @Date: 2020/10/22 19 47
 **/
public class T30 {
    Stack<Integer> A,B;
    public T30(){
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x) {
            B.add(x);
        }
    }
    public void pop(){
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }
    public int top() {
        return A.peek();
    }
    public int min(){
        return B.peek();
    }
}

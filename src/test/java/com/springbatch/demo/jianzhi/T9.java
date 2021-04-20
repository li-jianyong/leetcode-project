package com.springbatch.demo.jianzhi;

import java.util.LinkedList;

/*
* 用两个栈实现队列
* */
public class T9 {
    LinkedList<Integer> A, B;
    public T9() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    public void appendTail(int value) {
        A.addLast(value);
    }
    public int deleteHead() {
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1;
        // 只要A不为空，就将元素转移到B里。
        while(!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }
}

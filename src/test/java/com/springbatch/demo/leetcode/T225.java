package com.springbatch.demo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/** Leetcode 225 用两个队列实现栈
 * @author: lijianyong
 * @since: 2021/7/4 10:40
 */
public class T225 {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public T225() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    /** 每次插入一个q2,将q1的数据移动到，q2,
     * 依次想象元素依次插入的场景，插入1，两个队列为空，插入后，q2为空，q1有一个1；
     * 插入2， 先插入q2,然后依次将q1的元素转移到q2,然后q1和q2互换，此时q1的元素则是，2，1；那么弹出元素则是1先出，
     * @param x
     */
    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }
    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        for (int i=0;i<10000;i++) {
            System.out.println("翠花~翠花是什么：");
            System.out.println("\t" + "是傻子");
        }
    }
}

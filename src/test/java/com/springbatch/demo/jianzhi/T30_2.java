package com.springbatch.demo.jianzhi;

/**
 * @ClassName:T30_2
 * @author: Administrator
 * @Date: 2020/10/22 20 00
 **/
public class T30_2 {
    private ListNode head;
    public void push(int x) {
        if (head == null) {
            head = new ListNode(x,x,null);
        } else {
            head = new ListNode(x,Math.min(x,head.min),head);
        }
    }
    public void pop() {
        if(head ==null) throw new IllegalStateException("栈为空");
        head = head.next;
    }
    public int top() {
        if (head==null) throw new IllegalStateException("栈为空");
        return head.val;
    }
    public int min() {
        if (head == null) throw new IllegalStateException("栈为空");
        return head.min;
    }
    private class ListNode{
        int val;
        int min;
        ListNode next;
        ListNode(int val,int min,ListNode node) {
            this.val = val;
            this.min = min;
            this.next = node;
        }
    }
}

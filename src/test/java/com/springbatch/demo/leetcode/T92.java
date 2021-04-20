package com.springbatch.demo.leetcode;

import org.junit.Test;

/**
 * 92. 反转链表 II
 */
public class T92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;
        int step = 0;
        while(step < left - 1) {
            g = g.next;
            p = p.next;
            step++;
        }
        // 此时g位于第一个反转节点前面一个节点，p位于该反转节点位置.期间right-left个元素需要反转；
        for (int i=0;i<right-left;i++) {
            // 循环这么多次，将p后面的元素往前挪动
            ListNode removed = p.next;
            p.next = p.next.next;
            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;
    }
    @Test
    public void test(){
        int a = 2;
        if (a>0) {
            System.out.println(1);
        } else if (a > 1) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}

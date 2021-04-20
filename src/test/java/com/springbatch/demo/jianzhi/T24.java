package com.springbatch.demo.jianzhi;

import com.springbatch.demo.leetcode.ListNode;

/**
 * 反转链表
 */
public class T24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

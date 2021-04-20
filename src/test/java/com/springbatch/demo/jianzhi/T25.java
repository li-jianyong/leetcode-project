package com.springbatch.demo.jianzhi;

import com.springbatch.demo.leetcode.ListNode;

/**
 * 合并排序链表
 */
public class T25 {
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        if(l1==null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0),cur = dummy;
        while(l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1!=null?l1:l2;
        return dummy.next;
    }
    // 递归解法
    public ListNode recur(ListNode l1,ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = new ListNode(l1.val);
            head.next = recur(l1.next,l2);
        } else {
            head = new ListNode(l2.val);
            head.next = recur(l1,l2.next);
        }
        return head;
    }
}

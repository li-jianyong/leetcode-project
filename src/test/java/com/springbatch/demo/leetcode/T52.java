package com.springbatch.demo.leetcode;

/**
 * 两个链表交点
 */
public class T52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode PA = headA;
    ListNode PB = headB;
        while (PA != PB) {
        PA = PA == null ? headB : PA.next;
        PB = PB == null ? headA : PB.next;
    }
        return PA;
    }
}

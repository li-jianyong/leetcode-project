package com.springbatch.demo.jianzhi;

import com.springbatch.demo.leetcode.ListNode;

/*剑指 Offer 18. 删除链表的节点
* */
public class T18 {
    public ListNode deleteNode(ListNode head,int val) {
        if(head == null) return head;
        if (head.val == val) return head.next;
        ListNode cur = head;
        while(cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
    // 解法2 哨兵节点
    public ListNode deleteNode1(ListNode head,int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head,cur=head;
        while(head!=null) {
            if(cur.val == val) {
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
    // 解法3 递归解法
    public ListNode deleteNode2(ListNode head,int val) {
        if (head == null) return head;
        if (head.val == val) return head.next;
        head.next = deleteNode(head.next,val);
        return head;
    }
}

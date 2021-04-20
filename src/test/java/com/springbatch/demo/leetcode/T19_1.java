package com.springbatch.demo.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/** 删除链表中的倒数第N个节点，返回删除元素后的链表
 * @ClassName:T19
 * @author: Administrator
 * @Date: 2020/12/9 22 29
 **/
public class T19_1 {
    @Test
    public void t(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        removeNthFromEnd(head,2);

        System.out.println();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n<0) return null;
        List<Integer> tmp = new ArrayList<>();
        while(head!=null) {
            tmp.add(head.val);
            head = head.next;
        }
        int len = tmp.size();
        if (n>len) return null;
        else tmp.remove(len - n);
        ListNode dummy = new ListNode(0);
        ListNode e = dummy;
        for(Integer a : tmp) {
            e.next = new ListNode(a);
            e = e.next;
        }
        return dummy.next;
    }
}

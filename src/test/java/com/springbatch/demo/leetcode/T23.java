package com.springbatch.demo.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个升序链表
 */
public class T23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            // 升序 小根堆，每次从堆顶取最小的
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node!=null) queue.add(node);
        }
        while(!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next!=null) queue.add(p.next);
        }
        return dummy.next;
    }
}

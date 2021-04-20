package com.springbatch.demo.jianzhi;

import com.springbatch.demo.leetcode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* 剑指 Offer 06. 从尾到头打印链表

 * */
public class T6 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    // 方法二 递归
    ArrayList<Integer> tmp = new ArrayList<>();
    public int[] revesePrint1(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i=0;i<res.length;i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
    void recur(ListNode head) {
        // 递归终止条件
        if (head == null) return;
        // 先递归后面的元素，然后再添加元素，结果就是逆序
        recur(head.next);
        tmp.add(head.val);
    }
}

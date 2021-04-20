package com.springbatch.demo.leetcode;

import lombok.Data;

/**
 * @ClassName:ListNode
 * @author: Administrator
 * @Date: 2020/12/14 22 07
 **/
@Data
public class ListNode {
    public ListNode next;
    public int val;
    public ListNode(int val) {
        val = val;
    }
}

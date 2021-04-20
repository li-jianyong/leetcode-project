package com.springbatch.demo.test1;

/**
 * @ClassName:ReverseLink
 * @author: Administrator
 * @Date: 2020/9/21 21 25
 **/
public class ReverseLink {
    /*
    * 执行链表反转
    * */
    public Node reverse(Node head) {
        // next保持原链表的后继节点，pre指向反转链表的最后引用
        Node next,pre=null;
        while(head!=null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
class Node {
    int val;
    public Node(int val) {
        this.val = val;
    }
    Node next;
}

package com.springbatch.demo.jianzhi;

import java.util.HashMap;
import java.util.Map;

/** 携带随意指针的复杂链表复制，深拷贝
 * @ClassName:T35
 * @author: Administrator
 * @Date: 2021/1/1 16 00
 **/
public class T35 {
    public Node copyRandomList(Node head) {
        if (head ==null) return null;
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while(cur!=null) {
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 新链表
        while(cur!=null) {
            map.get(cur).next = map.get(cur.next);
            // 拿到random指针对应的节点，然后当前指向它
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
class Node {
    int val;
    Node next, random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

package com.springbatch.demo.leetcode;

/**
 * 手动实现hash映射结构
 */
public class T706 {
    class mapnode {
        int key,value;
        mapnode next;
        public mapnode(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }
    private mapnode[] map;
    private final int M = 4999;
    public T706(){
        map = new mapnode[M];
    }
    public void put(int key,int value) {
        if (map[key%M] == null) map[key%M] = new mapnode(key,value);
        else if (map[key%M].key == key) map[key%M].value = value;
        else {
            mapnode p = map[key%M];
            while(p.next != null&&p.next.key!=key) p = p.next;
            if (p.next == null) p.next = new mapnode(key,value);
            else p.next.value = value;
        }
    }
    public int get(int key) {
        mapnode p = map[key%M];
        while (p != null) {
            if (p.key == key) return p.value;
            p = p.next;
        }
        return -1;
    }
    public void remove(int key) {
        if (map[key%M] == null) return;
        if (map[key%M].key == key) {
            map[key%M] = map[key%M].next;
            return;
        }
        mapnode p = map[key%M];
        while(p.next!=null) {
            if (p.next.key == key) {
                p.next = p.next.next;
                return;
            }
        }
    }
    class Node{
        int key,value;
        Node next;
        public Node(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }
}

package com.springbatch.demo.leetcode;

/** 并查集
 * @ClassName:T547
 * @author: Administrator
 * @Date: 2020/10/14 16 14
 **/
public class T547 {
    public int findCircleNum(int[][] M) {
        int n= M.length;
        UF uf = new UF(n);
        for (int i=0;i<n;i++) {
            for (int j=0;j<i;j++) {
                if (M[i][j] == 1) {
                    uf.union(i,j);
                }
            }
        }
        return uf.count();
    }
}
class UF {
    // 连通分量个数
    private int count;
    // 存储若干颗树，也就是整个森林
    private int[] parent;
    // 记录数的重量
    private int[] size;
    public UF(int n){
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public void union(int p,int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // 如果rootP节点的树重，那就将rootP作为最后的根
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] = size[rootP];
        }
        count--;
    }
    public boolean connected(int p,int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
    // 路径压缩 找x元素对应的根，如果x的父元素不为根的话，将x跳转到x的祖父节点
    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public int count() {
        return count;
    }
}

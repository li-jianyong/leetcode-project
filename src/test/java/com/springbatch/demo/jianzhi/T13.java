package com.springbatch.demo.jianzhi;

import java.util.LinkedList;
import java.util.Queue;

/** 剑指 Offer 13. 机器人的运动范围
 * @ClassName:T10
 * @author: Administrator
 * @Date: 2020/10/8 10 31
 **/
public class T13 {
    // 剑指offer 13 增量突变的形式，因为被10整除的时候会发生突变现象
    int m,n,k;
    boolean[][] visited;
    public int movingCount(int m,int n,int k) {
        this.m = m;
        this.n =n;
        this.k =k;
        this.visited = new boolean[m][n];
        return dfs(0,0,0,0);
    }
    private int dfs(int i,int j,int si,int sj) {
        if(i>=m || j>=n || k<si+sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1+dfs(i+1,j, (i+1)%10 !=0 ? si+1 : si-8,sj) + dfs(i,j+1,si,(j+1)%10 != 0?sj+1:sj-8);
    }
    private int movingCountBfs(int m,int n,int k) {
        boolean[][] visited = new boolean[m][n];
        int res=0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0,0});
        while(queue.size()>0) {
            int[] x = queue.poll();
            int i =x[0],j=x[1],si=x[2],sj=x[3];
            if(i>=m||j>=n||k<si+sj||visited[i][j]) continue;
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i+1,j,(i+1)%10 != 0 ? si+1:si-8,sj});
            queue.add(new int[]{i,j+1,si,(j+1)%10 != 0 ? sj+1:sj-8});

        }
        return res;
    }
}

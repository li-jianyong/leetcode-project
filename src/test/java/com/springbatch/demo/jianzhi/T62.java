package com.springbatch.demo.jianzhi;

import java.util.ArrayList;

/** 剑指 Offer 62. 圆圈中最后剩下的数字
 * @ClassName:T62
 * @author: Administrator
 * @Date: 2020/10/26 14 53
 **/
public class T62 {
    // 方法1
    public int lastRemaining(int n,int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i=0;i<n;i++) {
            list.add(i);
        }
        int idx = 0;
        while(n>1) {
            // 下个要删除的位置
            idx = (idx + m -1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
    // 方法2：数学结论，根据结果反推，最后的索引位置是0，加上次数m,对每轮剩下的人数取模
    public int lastRemaining1(int n,int m) {
        int ans = 0;
        for (int i=2;i<=n;i++) {
            ans = (ans+m) % i;
        }
        return ans;
    }

}

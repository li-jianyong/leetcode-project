package com.springbatch.demo.leetcode;

/**
 * 1011. 在 D 天内送达包裹的能力
 */
public class T1011 {
    public int shipWithinDays(int[] weights, int D) {
        int l = 1,r = (int)1e8;
        while(l < r) {
            int mid = l + r >> 1;
            // 如果满足运力，那么向左移动寻找
            if (check(weights,mid,D)) {
                r = mid;
            } else {
                // 如果不满足，说明当前运力太小，要扩大运力，继续向右找
                l = mid + 1;
            }
        }
        return r;
    }

    boolean check(int[] ws, int t, int d) {
        if (ws[0] > t) return false;
        int n = ws.length;
        int cnt = 1;
        for (int i = 1, sum = ws[0]; i < n; sum = 0, cnt++) {
            if (ws[0] > t) return false;
            while (i < n && sum + ws[i] <= t) {
                sum += ws[i];
                i++;
            }
        }
        return cnt - 1 <= d;
    }
}

package com.springbatch.demo.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * 连续数字的和为s的序列集合
 */
public class T57_2 {
    public int[][] findContinuousSequence(int target) {
        int i =1,j=1,sum=0;
        List<int[]> res = new ArrayList<>();
        while(i<=target/2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] arr = new int[j-i];
                for (int k=i;k<j;k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 收缩窗口
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

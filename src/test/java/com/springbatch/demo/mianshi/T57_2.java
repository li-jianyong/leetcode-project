package com.springbatch.demo.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:T57_2
 * @author: Administrator
 * @Date: 2020/10/21 17 02
 **/
public class T57_2 {
    public int[][] findContinuousSequence(int target) {
        int i=1,j=1;
        int sum=0;
        List<int[]> res = new ArrayList<>();
        while(i<=target/2) {
            if (sum < target) {
                sum +=j;
                j++;
            } else if(sum > target) {
                sum -= i;
                i++;
            } else {
                int[] arr = new int[j-i];
                for(int k=i;k<j;k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                sum -= i;
                i++;
            }
        }
    return res.toArray(new int[res.size()][]);
    }
}

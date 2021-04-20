package com.springbatch.demo.jianzhi;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName:T61
 * @author: Administrator
 * @Date: 2020/10/26 14 42
 **/
public class T61 {
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        int count = 0;
        for (int a :nums) {
            if(a==0) continue;
            max = Math.max(max,a);
            min = Math.min(min,a);
            // 顺子中有相等的直接返回false
            if (repeat.contains(a)) return false;
            repeat.add(a);
        }
        return max-min<5;
    }
}

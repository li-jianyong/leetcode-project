package com.springbatch.demo.leetcode;

import java.util.*;

/**
 * 前K个高频元素 小根堆来维护
 */
public class T347 {
    public int[] topkFrequent(int[] nums,int k) {
        // 记录 数字，次数
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:nums) {
            if (map.containsKey(num)) {

            map.put(num,map.get(num) + 1);
            } else {
                map.put(num,1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                // 如果当前大，那就移除当前小的
                pq.remove();
                pq.add(key);
            }
        }
        // 结果集开始返回，最高的几个数字
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}

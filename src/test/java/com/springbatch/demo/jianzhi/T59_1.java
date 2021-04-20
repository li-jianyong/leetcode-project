package com.springbatch.demo.jianzhi;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值 单调队列
 */
public class T59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        // 维护单调队列
        Deque<Integer> deque = new LinkedList<>();
        // 最后的结果是length-k+1
        int[] res = new int[nums.length- k + 1];
        for (int j=0,i=1-k;j<nums.length;i++,j++) {
            // 将i=1-k是窗口形成期，当i>0时，判断单调队列的首位是不是和前一位相等，如果是，则可以将其从首位移除
            if (i>0 && deque.peekFirst() == nums[i-1]) {
                deque.removeFirst();
            }
            // 每次判断最大值从窗口出去，如果队列不空，且最后的一个数值比即将加入窗口的值小，那就将最后一个值加入进来
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) deque.addLast(nums[j]);
            // i>=0时，j=3
            if (i >= 0) res[i] = deque.peekFirst();
        }
        return res;
    }
    // 方法2
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) { // 未形成窗口
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for(int i = k; i < nums.length; i++) { // 形成窗口后
            // 如果队首与当前最大值一样大，则需要移除
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            // 为了能够保持单调队列，必须保证单调性，如果即将加入进来的数字比前面小的都从队列里移除；保证单调队列的队首值最大，队尾值最小
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}

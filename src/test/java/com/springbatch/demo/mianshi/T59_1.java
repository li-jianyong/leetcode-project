package com.springbatch.demo.mianshi;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName:T59_1
 * @author: Administrator
 * @Date: 2020/10/22 18 14
 **/
public class T59_1 {
    public int[] maxSlideWindow(int[] nums,int k) {
        if (nums==null || k<1||nums.length < k) {
            return new int[0];
        }
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i=0;i<nums.length;i++) {
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekFirst() == (i-k)) {
                queue.pollFirst();
            }
            if (i >= (k-1)) {
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
    // 滑动窗口 方法二
    public int[] maxSlideWindow1(int[] nums,int k) {
            if(nums.length == 0|| k==0) return new int[0];
            Deque<Integer> deque = new LinkedList<>();
            int[] res = new int[nums.length - k+1];
            for (int j=0,i=1-k;j<nums.length;i++,j++) {
                if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                    deque.removeFirst();
                }
                while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                    deque.removeLast();
                }
                deque.addLast(nums[j]);
                if (i >= 0) {
                    res[i] = deque.peekFirst();
                }
            }
            return res;
    }
}

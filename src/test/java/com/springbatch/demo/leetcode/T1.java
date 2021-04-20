package com.springbatch.demo.leetcode;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:T1
 * @author: Administrator
 * @Date: 2020/9/27 20 40
 **/
public class T1 {
    @Test
    public void t1(){

    }
    List<Integer> answer = new ArrayList<>();
    int base,count,maxCount;
    public int[] findMode(TreeNode node) {
        dfs(node);
        int[] mode = new int[answer.size()];
        for (int i = 0;i<answer.size();i++) {
            mode[i] = answer.get(i);
        }
        return mode;
    }
    public void dfs(TreeNode node) {
        if (node ==null) return;;
        dfs(node.left);
        update(node.val);
        dfs(node.right);
    }
    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            base = x;
            count = 1;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }
    public int trap(int[] height) {
        int sum =0;
        for (int i = 1; i < height.length -1; i++) {
            int max_left = 0;
            for(int j = i-1;j>=0;j--) {
                if(height[j] > max_left) {
                    max_left =height[j];
                }
            }
            int max_right = 0;
            for(int j =i+1;j<height.length;j++) {
                if (height[j]>max_right) {
                    max_right = height[j];
                }
            }
            int min = Math.min(max_left,max_right);
            if (min > height[i]) {
                sum += min-height[i];
            }
        }
        return sum;

    }
    // 动态规划解法，max_left[i]表示位置i左侧的最高高度
    public int trap1(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}

package com.springbatch.demo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 找到两数字之和，在树形结构里，任意两个位置的数字
 */
public class T653 {
    public boolean findTarget(TreeNode root ,int k) {
        if (root == null) return false;
        List<Integer> nums = new ArrayList<>();
        // 中序遍历 将结果放到list里
        inOrder(root,nums);
        int len = nums.size();
        int left = 0,right = len-1;
        while(left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum < k) {
                left++;
            } else if(sum > k) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
    void inOrder(TreeNode root,List<Integer> nums) {
        if (root == null) return;
        inOrder(root.left,nums);
        nums.add(root.val);
        inOrder(root.right,nums);
    }
    // 方法2
    private boolean find(TreeNode root, int target, Set<Integer> set) {
        if (root ==null) return false;
        if (set.contains(target - root.val)) return true;
        set.add(root.val);
        return find(root.left,target,set) || find(root.right,target,set);
    }
}

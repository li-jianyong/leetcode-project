package com.springbatch.demo.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName:T36_copy
 * @author: Administrator
 * @Date: 2021/1/6 20 32
 **/
public class T36_copy {
    // 存放结果
    List<String> res = new LinkedList<>();
    // 全排列核心算法逻辑
    private List<String> permuate(String s) {
        // 处理字符数组，通过交换来形成多排序
        char[] arr = s.toCharArray();
        dfs(arr,0);
        return res;
    }
    void dfs(char[] arr,int x) {
        if (x == arr.length -1) {
            res.add(String.valueOf(arr));
        }
        // set小剪枝去重
        HashSet<Character> set = new HashSet<>();
        for (int i=x;i<arr.length;i++) {
            if (set.contains(arr[x])) continue;
            set.add(arr[x]);
            swap(arr,i,x);
            dfs(arr,x+1);
            swap(arr,i,x);
        }
    }
    void swap(char[] arr,int i,int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

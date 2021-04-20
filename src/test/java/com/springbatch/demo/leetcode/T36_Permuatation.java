package com.springbatch.demo.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/** 全排列的思路，回溯，每次将某个元素固定到第一位，然后将其他元素进行全排列，继续固定在第一位
 * 将字符串转成数组 然后通过交换数组位置形成字符串添加到list里，从0开始进行深度遍历，每次都从要固定位置开始后面的元素进行深度遍历
 * @ClassName:T36
 * @author: Administrator
 * @Date: 2020/10/10 17 30
 **/
public class T36_Permuatation {
    List<String> res = new LinkedList<>();
    public String[] permutation(String s) {
        char[] c = s.toCharArray();
        dfs(c,0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(char[] c,int x) {
        // 如果固定的位置到了最后的以为，则可以将当前字符数组形成字符串添加到结果list里。
        if(x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        // 从x位置到末尾，每个元素的全排列
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(c,i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(c,x + 1); // 开启固定第 x + 1 位字符
            swap(c,i, x); // 恢复交换
        }
    }
    void swap(char[] c,int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
    @Test
    public void t(){
        String s = "123";
        System.out.println(permutation(s));
    }
}

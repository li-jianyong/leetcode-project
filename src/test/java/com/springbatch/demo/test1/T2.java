package com.springbatch.demo.test1;

import lombok.Data;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName:T2
 * @author: Administrator
 * @Date: 2020/11/13 15 51
 **/
public class T2 {
    /*
    * 测试将扁平化对象转化为树形对象{'A':1,'b.b':3,'cc.d.e':4,'cc.d.f':5}
    * {
    *   'A':1,
    *   'b':{
    *       'b':3
    *   },
    *   'cc':{
    *       'd':{
    *           'e':4
    *       },
    *       'f':5
    *   }
    *
    * }
    * */
    @Test
    public void t1(){
        Map<String,Object> map = new HashMap<>();
        map.put("a",1);
        map.put("b.b",3);
        map.put("cc.d.e",4);
        map.put("cc.d.f",5);

    }
    @Data
    private static class TreeNode{
        private String key;
        private int value;
        private TreeNode node;
        public TreeNode(){
        }
        public TreeNode(String key,int value) {
            this.key = key;
            this.value = value;
        }
    }
    // dfs1 12345全排列 使用used数组来表明使用情况 如果待排序元素有相同字符，结果也会有重复值
    // dfs2 排序过程中剔除重复元素 得到不重复的全排列,最简单的处理方式用set容器去收集最后的结果 通过交换元素位置来set收集
    @Test
    public void t(){
        String str = "122";
        char[] nums = str.toCharArray();
        List<String> res = new ArrayList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        StringBuilder path = new StringBuilder();
        dfs1(nums,len,0,path,used,res);
//        dfs2(nums,0,res);
        System.out.println(res);
        System.out.println(res.size());

    }
    private void dfs1(char[] nums,int len,int depth,StringBuilder path,boolean[] used,List<String> res) {
        if (depth == len) {
            res.add(path.toString());
            return;
        }
        // 衡量当前收集元素得长度
        for (int i = 0;i<len;i++) {
            if (!used[i]) {
                path.append(nums[i]);
                used[i]=true;
                dfs1(nums,len,depth+1,path,used,res);
                used[i]=false;
                path.deleteCharAt(path.length()-1);
            }
        }
    }
    private void dfs2(char[] nums,int begin,List<String> res) {
        if (begin == nums.length - 1) {
            res.add(String.valueOf(nums));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i= begin;i<nums.length;i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(nums,i,begin);
            dfs2(nums,begin+1,res);
            swap(nums,i,begin);
        }
    }
    void swap(char[] nums, int a, int b) {
        char tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

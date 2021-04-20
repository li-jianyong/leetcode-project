package com.springbatch.demo.test1;

import org.junit.Test;

import java.util.*;

public class T3 {
    List<Integer> resList = new ArrayList<>();
    public int getMaxValue (int[] nums, int[] values) {
        // values数组保持顺序不变，nums数组和values数组大小一致
        if(nums.length==0||values.length==0) return -1;
        int len1 = nums.length,len2 = values.length;
        int res = 0;
        dfs(nums,values,0,len1-1,0,res);
        return res;
    }
    void dfs(int[] nums,int[] values,int nl,int nr,int vl,int res) {
        // base case
        if (nl > nr) {
            resList.add(res);
        }
        while(nl <= nr) {
            res += nums[nl] * values[vl];
        }
    }

    // t2
    public int[] tranArr (int[] arrA, int K) {
        // 先得到极差
        int len = arrA.length;
        int[] temp = new int[len];
        for (int i=0;i<len;i++) {
            temp[i]=arrA[i];
        }
        Arrays.sort(arrA);
        int diff = arrA[len-1] - arrA[0];
        // 判断最小值是否唯一
        if (diff > 2 * K) {
           arrA[0] += K;
           arrA[len-1] -= K;
           return arrA;
        } else {
            // 存在大小值覆盖的情形 最小值为0，头尾能连在一起，那么中间也能连在一起
            int mid = (arrA[len-1] - arrA[0]) / 2;
            Arrays.fill(arrA,arrA[len-1]-mid);
            return arrA;
        }


    }

    @Test
    public void test(){
        int[] nums = {1,100};
        int[] values = {2,1};
        int maxValue = getMaxValue(nums, values);
        System.out.println(maxValue);
    }

}

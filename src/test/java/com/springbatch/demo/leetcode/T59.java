package com.springbatch.demo.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 螺旋矩阵2
 */
public class T59 {
    public int[][] generateMatrix(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];
        int t=0,b=n-1,l=0,r=n-1;
        while(true) {
            for(int i=l;i<=r;i++) matrix[t][i] = num++;
            if(++t > b) break;
            for(int i=t;i<=b;i++) matrix[i][r] = num++;
            if(--r < l) break;
            for(int i=r;i>=l;i--) matrix[b][i] = num++;
            if(--b < t) break;
            for(int i=b;i>=t;i--) matrix[i][l] = num++;
            if(++l > r) break;
        }
        return matrix;
    }
    @Test
    public void test(){
        int[][] ints = generateMatrix(3);

        System.out.println(Arrays.toString(ints));

    }
}

package com.springbatch.demo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 矩阵置0
 */
public class T73 {
    // 1、O(m+n)
    public void setZeroes(int[][] matrix) {
        Set<Integer> row_zero = new HashSet<>();
        Set<Integer> col_zero = new HashSet<>();
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i=0;i<row;i++) {
            for (int j=0;j<column;j++) {
                if (matrix[i][j] == 0) {
                    row_zero.add(i);
                    col_zero.add(j);
                }
            }
        }
        for (int i=0;i<row;i++) {
            for (int j=0;j<column;j++) {
                if (row_zero.contains(i) || col_zero.contains(j)) matrix[i][j] = 0;
            }
        }
    }
    // 思路2：原地o(1)算法
    public void setZeros2(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            boolean row0_flag = false;
            boolean col0_flag = false;
            // 第一行是否有零
            for (int j = 0; j < col; j++) {
                if (matrix[0][j] == 0) {
                    row0_flag = true;
                    break;
                }
            }
            // 第一列是否有零
            for (int i = 0; i < row; i++) {
                if (matrix[i][0] == 0) {
                    col0_flag = true;
                    break;
                }
            }
            // 把第一行第一列作为标志位
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }
            // 置0
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (row0_flag) {
                for (int j = 0; j < col; j++) {
                    matrix[0][j] = 0;
                }
            }
            if (col0_flag) {
                for (int i = 0; i < row; i++) {
                    matrix[i][0] = 0;
                }
            }
    }
}

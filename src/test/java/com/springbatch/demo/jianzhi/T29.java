package com.springbatch.demo.jianzhi;

/**
 * 旋转顺时针打印二维矩阵
 */
public class T29 {
    public int[] sprialOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l=0,r=matrix[0].length-1,t=0,b=matrix.length-1;
        int[] res = new int[(r+1) * (b+1)];
        int k=0;
        while(true) {
            for (int i=l;i<=r;i++) res[k++] = matrix[t][i];
            if (b < ++t) break;
            for (int i=t;i<=b;i++) res[k++] = matrix[i][r];
            if (l < --r) break;
            for (int i= r;i>=l;i--) res[k++] = matrix[b][i];
            if (t > --b) break;
            for (int i=b;i<=t;i++) res[k++] = matrix[i][l];
            if (r < ++l) break;
        }
        return res;
    }
}

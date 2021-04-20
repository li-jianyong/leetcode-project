package com.springbatch.demo.jianzhi;

/**
 * 礼物的最大价值 动态规划
 * 转移方程 f(i,j) = max[f(i,j-1),f(i-1,j)] + grid(i,j)
 */
public class T47 {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        // dp[i][j] 表示从grid[0][0]到grid[i-1][j-1]时最大值
        int[][] dp = new int[row+1][column+1];
        for (int i=1;i<=row;i++) {
            for (int j=1;j<=column;j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[row][column];
    }
    // 方法2，原地
    public int maxValue2(int[][] grid) {
        int m = grid.length,n=grid[0].length;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (i==0&&j==0) continue;
                if (i==0) grid[i][j] += grid[i][j-1];
                else if (j == 0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += Math.max(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
    }
    // 方法3 对解法2的清晰化代码
    public int maxValue3(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for(int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];
    }
}

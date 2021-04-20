package com.springbatch.demo.jianzhi;

/** 剑指 Offer 12. 矩阵中的路径
 * @ClassName:T10
 * @author: Administrator
 * @Date: 2020/10/8 10 31
 **/
public class T12 {
    // 剑指offer 12
    public boolean exist(char[][] board,String word) {
        // 要获得的字符串字符数组
        char[] words = word.toCharArray();
        // 双层遍历board数组 dfs遍历到每个位置进行判断
        for(int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (dfs(board,words,i,j,0)) return true;
            }
        }
        return false;
    }
    // 深度优先遍历 递归遍历先给定base case 然后dfs遍历能够避免死循环，逻辑简化
    boolean dfs(char[][] board,char[] word,int i,int j,int k) {
        // 以下四种情况，返回false
        if(i>=board.length || i<0||j>=board[0].length|| j<0 ||board[i][j]!=word[k]) return false;
        // 如果最终k的长度达到了length-1说明完成了字符串的寻找！
        if(k==word.length-1) return true;
        char temp = board[i][j];
        // 回溯的过程，将board[i][j]的值标识已访问，然后完成该过程后的遍历寻找。
            board[i][j]='/';
        boolean res = dfs(board,word,i+1,j,k+1) || dfs(board,word,i-1,j,k+1) ||
                dfs(board,word,i,j+1,k+1) || dfs(board,word,i,j-1,k+1);
        // 逆向回溯。更改为原先的值。
        board[i][j] = temp;
        return res;

    }
}

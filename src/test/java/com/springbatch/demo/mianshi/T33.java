package com.springbatch.demo.mianshi;

/** 二叉搜索树的后序遍历序列
 * @ClassName:T33
 * @author: Administrator
 * @Date: 2020/10/26 22 24
 **/
public class T33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }
    boolean recur(int[] postorder,int i,int j){
        if (i>=j) return true;
        int p = i;
        // 左子树找到最大点
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        // 右子树找到最小区间
        while (postorder[p] > postorder[j]) p++;
        // 左右的根一致，
        return p==j && recur(postorder,i,m-1) && recur(postorder,m,j-1);
    }
}

package com.springbatch.demo.jianzhi;

import com.springbatch.demo.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/** 根据先、中序列 重建二叉树
 * @ClassName:T7
 * @author: Administrator
 * @Date: 2020/12/31 13 46
 **/
public class T7 {
    private Map<Integer,Integer> reverse;
    private int[] preorder;
    public TreeNode buildTree(int[] preorder,int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            return null;
        }
        this.preorder = preorder;
        // 保留中序遍历的值和位置
        reverse = new HashMap<>(inLen);
        for (int i =0;i<inLen;i++) {
            reverse.put(inorder[i],i);
        }
        return buildTree(0,preLen -1,0,inLen-1);
    }

    /**
     * @param preL 先序遍历的左
     * @param preR 先序遍历的右
     * @param inL 中序遍历的左
     * @param inR 中序遍历的右
     * @return
     */
    private TreeNode buildTree(int preL,int preR,int inL,int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        // 二叉树根节点是前序遍历数组的第i个节点
        int pivot = preorder[preL];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = reverse.get(pivot);
        // 左子树的节点数量，中序pivot节点到左侧的个数 pivotIndex-inL;那么前序的右界 preL+pivotIndex-inL
        root.left = buildTree(preL+1,preL+(pivotIndex - inL),inL,pivotIndex-1);
        // 右子树，前序应该是pre的后半段pre前序的个数+1，为左边界，有边界到preR,中序遍历，为pivotIndex+1到末尾
        root.right = buildTree(preL+(pivotIndex-inL)+1,preR,pivotIndex+1,inR);
        return root;
    }
}

package com.springbatch.demo.mianshi;

/**
 * @ClassName:T68_1
 * @author: Administrator
 * @Date: 2020/10/26 19 41
 **/
public class T68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        while(root!=null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }else if(root.val > p.val && root.val > q.val) {
                root = root.left;
            } else
                break;
        }
        return root;
    }
}

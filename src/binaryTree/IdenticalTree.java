package binaryTree;

import binarySearchTree.TreeNode;

public class IdenticalTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if((p==null && q!=null)|| (p!=null && q==null))return false;
        else if((p!=null && q!=null)&&(p.val != q.val))return false;


        boolean left=isSameTree(p.left, q.left);
        boolean right=isSameTree(p.right, q.right);

        if(left==false || right==false) return false;
        else return true;
    }
}

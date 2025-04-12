package binaryTree;
//import binarySearchTree.TreeNode;

import java.util.*;

public class BoundaryTraversal {

    public List<Integer> boundary(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        ans.add(root.val);

        List<Integer> l=new ArrayList<>();
        List<Integer> r=new ArrayList<>();
        List<Integer> lf=new ArrayList<>();

        left(root.left, l);
        right(root.right, r);
        leaves(root, lf);

        ans.addAll(l);
        ans.addAll(lf);
        ans.addAll(r);



        return ans;

    }

    public List<Integer> left(TreeNode root, List<Integer> l){
        if(root==null) return l;
        if(!isLeaf(root))l.add(root.val);
        if (root.left==null)return  left(root.right, l);
        else {
            return left(root.left, l);
        }
    }

    public List<Integer> right(TreeNode root, List<Integer> r){
        if(root==null) return r;
        if(!isLeaf(root))r.add(0,root.val);
        if (root.right==null)return  right(root.left, r);
        else {
            return right(root.right, r);
        }
    }

    public void leaves(TreeNode root, List<Integer> lf){
        if(root==null) return;
        if(isLeaf(root)){
            lf.add(root.val);
        }
        leaves(root.left, lf);
        leaves(root.right, lf);
    }

    public boolean isLeaf(TreeNode root){
        if(root==null) return false;
        if(root.left == null && root.right == null) return true;
        else return false;
    }


    public static void main(String[] args) {
        BoundaryTraversal obj=new BoundaryTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(6);

        List<Integer> res=obj.boundary(root);
        System.out.println(res);
    }






}

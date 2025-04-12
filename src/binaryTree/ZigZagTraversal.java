package binaryTree;


import binarySearchTree.TreeNode;

import java.util.*;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root); boolean lr=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> level=new ArrayList<>();


            // int ind=0;
            // if(lr)ind=0;
            // else ind=size-1;

            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(lr){
                    level.add(temp.val);
                    // ind++;
                }else{
                    level.add(0,temp.val);
                    // ind--;
                }
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
            ans.add(level);
            lr=!lr;

        }
        return ans;

    }
}

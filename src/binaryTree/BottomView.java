package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
    static class Pair{
        TreeNode node;
        int col;
        Pair(TreeNode node, int col){
            this.node=node;
            this.col=col;
        }
    }
    public void bottomView(TreeNode root, ArrayList<Integer> ans){

        Queue<Pair> q=new LinkedList<>();
        TreeMap<Integer, TreeNode> m=new TreeMap<>();

        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair temp=q.poll();
            TreeNode node=temp.node;
            int col= temp.col;

            m.put(col, node);

            if(node.left != null){
                q.add(new Pair(node.left, col-1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, col+1));
            }
        }

        for(Integer i:m.keySet()){
            ans.add(m.get(i).val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(6);


        BottomView obj=new BottomView();
        ArrayList<Integer> ans=new ArrayList<>();
        obj.bottomView(root, ans);

        System.out.println(ans);
    }
}

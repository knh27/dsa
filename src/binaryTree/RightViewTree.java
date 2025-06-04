package binaryTree;

import java.util.*;


public class RightViewTree {
    static class Pair{
        TreeNode node;
        int row;
        Pair(TreeNode node, int row){
            this.node=node;
            this.row=row;
        }
    }
    public void rightView(TreeNode root, List<Integer> ans){
        Queue<Pair> q=new LinkedList<>();
        Map<Integer, TreeNode> m=new TreeMap<>();

        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair temp=q.poll();
            TreeNode node=temp.node;
            int row=temp.row;

            m.put(row, node);

            if(node.left != null){
                q.add(new Pair(node.left, row+1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, row+1));
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

        RightViewTree obj=new RightViewTree();
        ArrayList<Integer> ans=new ArrayList<>();
        obj.rightView(root, ans);
        System.out.println(ans);
    }


}

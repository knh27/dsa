package binaryTree;

import java.util.*;

public class TopViewTree {

    static class Pair{
        TreeNode node;
        Integer col;
Pair(TreeNode node, Integer col){
            this.node=node;
            this.col=col;
        }
    }

    public void topView(TreeNode root, List<Integer> l){
        Queue<Pair> q=new LinkedList<>();
        TreeMap<Integer, TreeNode> m=new TreeMap<>();

        q.add(new Pair(root, 0));
        while (!q.isEmpty()){

            Pair temp=q.poll();
            TreeNode node=temp.node;
            int col= temp.col;

            m.putIfAbsent(temp.col, temp.node);

            if(node.left!=null){
                q.add(new Pair(node.left, col-1));
            }

            if(node.right !=null){
                q.add(new Pair(node.right, col+1));
            }

        }
        for(Integer item:m.keySet()){
//            System.out.println(m.keySet());
            TreeNode atCol=m.get(item);
            l.add(atCol.val);
        }
        System.out.println(l);
    }

    public static void main(String[] args) {
        TopViewTree obj=new TopViewTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(6);

        List<Integer> ans=new ArrayList<>();
        obj.topView(root, ans);
    }



}

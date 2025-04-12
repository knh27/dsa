package binaryTree;

import java.awt.event.PaintEvent;
import java.util.*;

public class VerticalOrderTraversal{

    static class Pair{
        TreeNode node;
        Integer col;
        Integer row;

        Pair(TreeNode node,int row, int col ){
            this.row=row;
            this.col=col;
            this.node=node;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root){
        List<List<Integer>> ans=new ArrayList<>();
        bfs(root, ans);

        return ans;

    }

    public void bfs(TreeNode root, List<List<Integer>> ans){
        Queue<Pair> q=new LinkedList<>();

        Map<Integer, Map<Integer, PriorityQueue<Integer>>> m=new TreeMap<>();
        q.add(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair temp=q.poll();

            TreeNode node=temp.node;
            int row=temp.row;
            int col=temp.col;

            m.putIfAbsent(col, new TreeMap<>());
            m.get(col).putIfAbsent(row, new PriorityQueue<>());
            m.get(col).get(row).offer(node.val);

            if(node.left!=null){
                q.add(new Pair(node.left, row+1, col-1));
            }
            if(node.right !=null){
                q.add(new Pair(node.right, row+1, col+1));
            }
        }

        for(Map<Integer , PriorityQueue<Integer>> rows:m.values()){
            List<Integer> colList =new ArrayList<>();
            for(PriorityQueue<Integer> nodes:rows.values()){
                while (!nodes.isEmpty()) {
                    colList.add(nodes.poll());
                }
            }
            ans.add(colList);

        }

    }

    public static void main(String[] args) {
        VerticalOrderTraversal obj=new VerticalOrderTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(6);

        List<List<Integer>> res=obj.verticalOrder(root);
        for(List<Integer> l:res){
            System.out.println(l);
        }
    }




}

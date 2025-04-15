package binaryTree;

import java.util.*;

public class MaximumWidth {
    class Pair{
        int row;
        int col;
        TreeNode node;
        Pair(TreeNode node ,int row, int col){
            this.row=row;
            this.col=col;
            this.node=node;
        }
    }

    public int maxWidthOfBT(TreeNode root){
        if(root==null) return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root, 0,0));

        int max=0;
        while(!q.isEmpty()){
            int minInd=q.peek().col;

            int size=q.size();
            int colFirst=0,colLast=0;
            for(int i=0;i<size;i++){
                Pair temp=q.poll();
                System.out.println(temp.node.val);

                TreeNode tempNode=temp.node;
                int col=temp.col-minInd;
                int row=temp.row;

                if(i==0){
                    colFirst=temp.col;
                }
                if(i==size-1){
                    colLast=temp.col;
                }

                max=Math.max(max, colLast-colFirst+1);



                if(tempNode.left!=null){
                    q.add(new Pair(tempNode.left, row+1, 2*col));
                }
                if(tempNode.right !=null){
                    q.add(new Pair(tempNode.right, row+1, 2*col+1));
                }
            }


        }


        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(6);

        MaximumWidth obj=new MaximumWidth();
        System.out.println(obj.maxWidthOfBT(root));
    }
}

package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    public boolean inOrder(TreeNode root, TreeNode node, ArrayList<Integer> l){
        if(root==null){
            return false;
        }
        l.add(root.val);
        if(root.val==node.val) return true;
        boolean leftVal=inOrder(root.left, node, l);
        boolean rightVal=inOrder(root.right, node, l);
        if(leftVal==false && rightVal==false){
            l.remove(l.size()-1);
            return false;
        }
        else return true;



    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(6);

        TreeNode target=new TreeNode(7);

        ArrayList<Integer> l=new ArrayList<>();
        RootToNodePath obj=new RootToNodePath();
        obj.inOrder(root, target, l);
        System.out.println(l);
    }
}

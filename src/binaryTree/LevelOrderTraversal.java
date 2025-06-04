package binaryTree;

import java.util.*;

public class LevelOrderTraversal {
    public void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            System.out.println(temp.val);
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
    }

    public List<List<Integer>> levelOrderTraversal2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                l.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            ans.add(l);

        }
        return ans;
    }
}

package binaryTree;
import java.util.*;

public class KthDistanceNode {



    public List<Integer> nodeAtKthDistance(TreeNode root, TreeNode target, int k){

        Queue<TreeNode> q=new LinkedList<>();
        Map<TreeNode, TreeNode> m=new HashMap<>();

        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();

            if(temp.left != null){
                m.put(temp.left, root);
                q.add(temp.left);
            }
            if(temp.right != null){
                m.put(temp.right, root);
                q.add(temp.right);
            }
        }
        List<Integer> l=new ArrayList<>();
        helper(target, l, 2);
        return l;

    }

    int count=0;
    public void helper(TreeNode target, List<Integer> l,int k){

    }
}

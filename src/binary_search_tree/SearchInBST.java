package binary_search_tree;

public class SearchInBST {
    public static void main(String[] args) {

    }

}


 //Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
     public TreeNode searchBST(TreeNode root, int val) {
         if(root==null) return null;
         else if(root.val==val) return root;
         else if(root.val>val) return searchBST(root.left, val);
         else return searchBST(root.right, val);

     }

    public TreeNode searchBST_Iterative(TreeNode root, int val){

        while(true){
            if(root==null) return null;
            else if(root.val==val) return root;
            else if(root.val>val)root=root.left;
            else if(root.val<val)root=root.right;

        }
    }
}

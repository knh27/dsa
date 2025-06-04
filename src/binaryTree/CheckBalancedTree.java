package binaryTree;


public class CheckBalancedTree {


    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }






    public boolean isBalanced_bruteForce(TreeNode root) {
        if(root==null) return true;
        int lh=height(root.left);
        int rh=height(root.right);

        if(Math.abs(lh-rh)>1) return false;
        else return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if(root==null)return 0;
        if(root.left==null && root.right==null) return 1;
        return Math.max(height(root.left), height(root.right))+1;

    }



}













package binaryTree;



public class DiameterBinaryTree{
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxD=new int[1];
        maxD[0]=0;
        findMax(root, maxD);
        return maxD[0];
    }

    int findMax(TreeNode root, int[] maxD){
        if(root==null) return 0;
        int lh=findMax(root.left,maxD);
        int rh=findMax(root.right, maxD);
        maxD[0]=Math.max(lh+rh, maxD[0]);
        return Math.max(lh, rh)+1;
    }
}

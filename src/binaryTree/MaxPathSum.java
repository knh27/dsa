package binaryTree;


public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] a=new int[1];
        a[0]=Integer.MIN_VALUE;
        helper(root, a);
        return a[0];

    }

    public int helper(TreeNode root, int[] a){
        if(root==null ){
            return 0;
        }
        int leftSum=helper(root.left, a);
        int rightSum=helper(root.right, a);

        int leftSumPos=Math.max(leftSum, 0);
        int rightSumPos=Math.max(rightSum, 0);

        a[0]=Math.max(leftSumPos+root.val+rightSumPos, a[0]);
        // if(root.val<0) return Math.max(leftSumPos, rightSumPos);
        return root.val+Math.max(leftSumPos, rightSumPos);
    }
    int maxSum=0;
    public int fun(TreeNode root){
        if(root==null) return 0;
//        if(root.val<0) return 0;

        int lh=fun(root.left);
        int rh=fun(root.right);

        if(lh<0) lh=0;
        if(rh<0) rh=0;

        int pathThroughRoot=root.val+lh+rh;
        int sum=Math.max(root.val+lh, root.val+rh);
        maxSum=Math.max(maxSum, pathThroughRoot);
        return sum;
    }




















}


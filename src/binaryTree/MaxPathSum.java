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
}


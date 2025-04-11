package binary_search_tree;

public class HeightTree {

    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        // if(root.left==null && root.right==null) return 1;
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);
        return 1+Math.max(lh, rh);
    }
}

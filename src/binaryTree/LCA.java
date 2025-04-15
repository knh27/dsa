package binaryTree;

public class LCA {
//    public boolean lowestCommonAncestor(TreeNode root, int val1, int val2, int[] a){
//        if(root==null) return false;
//        if(root.val==val1 || root.val==val2) return true;
//
//        boolean leftVal=lowestCommonAncestor(root.left, val1, val2, a);
//        boolean rightVal=lowestCommonAncestor(root.right, val1, val2, a);
//        if(leftVal==false && rightVal==false) return false;
//        else if(leftVal==true && rightVal==true){
//            a[0]=root.val;
//            return true;
//        }
//        return true;
//    }
    public TreeNode lowestCommonAncestor(TreeNode root, int val1, int val2){
        if(root==null) return null;
        if(root.val==val1 ) return root;
        if(root.val==val2)return root;

        TreeNode leftVal=lowestCommonAncestor(root.left, val1, val2 );
        TreeNode rightVal=lowestCommonAncestor(root.right, val1, val2 );
        if(leftVal==null && rightVal==null) return null;
        else if(leftVal==null && rightVal!=null) return rightVal;
        else if(leftVal!=null && rightVal==null) return leftVal;
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(6);

        LCA obj=new LCA();

        System.out.println(obj.lowestCommonAncestor(root, 1, 7).val);
    }
}

package leetCode;


public class BalancedBinaryTree {
	private boolean result = true;

	public boolean isBalanced(TreeNode root) {
	    maxDepth(root);
	    return result;
	}

	public int maxDepth(TreeNode root) {
	    if (root == null)
	        return 0;
	    int l = maxDepth(root.left);
	    int r = maxDepth(root.right);
	    if (Math.abs(l - r) > 1)
	        result = false;
	    return 1 + Math.max(l, r);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

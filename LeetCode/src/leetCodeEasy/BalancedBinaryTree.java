package leetCodeEasy;


public class BalancedBinaryTree {
//	private boolean result = true;
//
//	public boolean isBalanced(TreeNode root) {
//	    maxDepth(root);
//	    return result;
//	}
//
//	public int maxDepth(TreeNode root) {
//	    if (root == null || !result)
//	        return 0;
//	    int l = maxDepth(root.left);
//	    int r = maxDepth(root.right);
//	    if (Math.abs(l - r) > 1)
//	        result = false;
//	    return 1 + Math.max(l, r);
//	}
	
	//Second round
	public boolean isBalanced(TreeNode root) {
        int res = heightOfTree(root);
        return res != -1;
    }
	// if the tree is balanced , return the height of the tree
    // if the tree is unbalanced, return -1 to denote it isn't balanced
    public int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

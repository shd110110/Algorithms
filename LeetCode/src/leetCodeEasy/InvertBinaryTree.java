package leetCodeEasy;

/**
 * @author Poirot
 * 2015年6月12日
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return root;
		}
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

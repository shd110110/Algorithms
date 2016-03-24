package leetCodeEasy;

/**
 * @author Poirot
 * 2015年7月11日
 */
public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.equals(root) || q.equals(root)) {
			return root;
		}
        if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
			return root;
		}else if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		}else {
			return lowestCommonAncestor(root.right, p, q);
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

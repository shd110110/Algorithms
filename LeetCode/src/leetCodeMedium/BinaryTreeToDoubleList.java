/**
 * 2016年3月17日
 * Poirot
 * 下午7:44:38
 * LeetCode
 */
package leetCodeMedium;

/**
 * @author Poirot
 *
 */
public class BinaryTreeToDoubleList {
	public TreeNode toDoubleList(TreeNode root) {
		if (root == null) {
			return null;
		}
		if ( root.left == null && root.right == null) {
			return root;
		}
		TreeNode node = new TreeNode(0);
		TreeNode pre = node;
		while (root != null) {
			TreeNode left = root.left;
			if (left != null) {
				while (left.right != null && left.right != root) {
					left = left.right;
				}
				if (left.right != null) {
					root.left = pre;
					pre.right = root;
					pre = root;
					root = root.right;
				} else {
					left.right = root;
					root = root.left;
				}
			} else {
				root.left = pre;
				pre.right = root;
				pre = root;
				root = root.right;
			}
		}
		TreeNode res = node.right;
		res.left = null;
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

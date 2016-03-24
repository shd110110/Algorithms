package leetCodeMedium;

/**
 * @author Poirot 2015年6月6日
 */
public class CountCompleteTreeNodes {

	// public int countNodes(TreeNode root) {
	// if (root == null) {
	// return 0;
	// }
	// int level = levelOfTree(root);
	// int levelLeft = levelOfTree(root.left);
	// int levelright = levelOfTree(root.right);
	// int judgeLeft = judge(root.left);
	// int judgeRight = judge(root.right);
	// if (levelLeft == levelright && judgeLeft == judgeRight) {
	// return (int) (Math.pow(2, level)) - 1;
	// } else {
	// if (levelLeft > levelright) {
	// return 1 + (int) (Math.pow(2, levelright)) - 1
	// + countNodes(root.left);
	// }else {
	// return 1 + (int) (Math.pow(2, levelLeft)) - 1
	// + countNodes(root.right);
	// }
	//
	// }
	// }
	//
	// public int levelOfTree(TreeNode root) {
	// int level = 0;
	// TreeNode temp = root;
	// while (temp != null) {
	// level++;
	// temp = temp.left;
	// }
	// return level;
	// }
	// public int judge(TreeNode root){
	// int level = 0;
	// TreeNode temp = root;
	// while (temp != null) {
	// level++;
	// temp = temp.right;
	// }
	// return level;
	// }

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}  
		int res = 0;
		int treeHeight = height(root);
		while (root != null) {
			 
			int rightHeight = height(root.right);
			  
			if (rightHeight + 1 == treeHeight) {
				res += (1 << rightHeight);
				root = root.right; 
			} else {
				res += (1 << rightHeight);
				root = root.left; 
			}
			treeHeight--;
		}
		return res;
	}

	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		} 
		int height = 1;
		while (root.left != null) {
			height++;
			root = root.left; 
		}
		return height;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(6);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(1);

		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;

		CountCompleteTreeNodes t = new CountCompleteTreeNodes();
		System.out.println(t.countNodes(root));
	}

}

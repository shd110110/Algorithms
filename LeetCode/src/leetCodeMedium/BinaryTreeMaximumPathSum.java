package leetCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot 2015年6月6日
 */
public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		// 经过root,或者不经过
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		}
		TreeNode root2 = findMaxSum(root);
//		TreeNode test = root2;
//		preorder(test);
//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i));
//		}
		return digui(root, root2);
	}
	public int digui(TreeNode root, TreeNode root2){
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		}
		
		// 经过root
		int left = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;
		if (root2.left != null) {
			left = root2.left.val;
		}
		if (root2.right != null) {
			right = root2.right.val;
		} 
		int passRoot = root.val;
		if (left > 0 && right <= 0) {
			passRoot = root.val + left; 
		}
		if (left <= 0 && right > 0) {
			passRoot = root.val + right; 
		}
		if (left > 0 && right > 0) {
			passRoot = root.val + left +right; 
		}
		// 不经过root
		int noPassRoot = Math.max(digui(root.left,root2.left), digui(root.right,root2.right));

		return Math.max(passRoot, noPassRoot);
	}

	public TreeNode findMaxSum(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return new TreeNode(root.val);
		}
		TreeNode node = new TreeNode(0);
		node.left = findMaxSum(root.left);
		node.right = findMaxSum(root.right);
		int left = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;
		if (node.left != null) {
			left = node.left.val;
		}
		if (node.right != null) {
			right = node.right.val;
		}
		node.val = Math.max(root.val+ Math.max(left, right),root.val);
		return node;
	}

	List<Integer> result = new ArrayList<Integer>();
	public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return result;
    }
	
	public void preorder(TreeNode root){
		if (root == null) {
			return ;
		}else {
			result.add(root.val);
			preorder(root.left);
			preorder(root.right);
			return ;
		}
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		root.left = second;
		root.right = third;
		BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();
		System.out.println(test.maxPathSum(root));
	}

}

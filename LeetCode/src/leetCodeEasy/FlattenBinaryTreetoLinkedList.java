package leetCodeEasy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenBinaryTreetoLinkedList {

	List<TreeNode> tempList = new ArrayList<>();
	public void flatten(TreeNode root) {
		TreeNode result = new TreeNode(0);
		TreeNode temp = result;
		add(root);
		Iterator<TreeNode> iter = tempList.iterator();
		while (iter.hasNext()) {	
			temp.right = iter.next();
			temp.left = null;
			temp = temp.right;
		}
		root = result.right;
    }
	public void add(TreeNode root){
		if (root == null) {
			return;
		}
		tempList.add(root);
		if (root.left != null ) {
			add(root.left);
		}
		if (root.right != null) {
			add(root.right);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

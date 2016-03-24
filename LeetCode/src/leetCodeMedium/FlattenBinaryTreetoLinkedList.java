/**
 * Dec 22, 2015
 * Poirot
 * 11:23:46 AM
 * LeetCode
 */
package leetCodeMedium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * @author Poirot
 *
 */


public class FlattenBinaryTreetoLinkedList {

//	List<TreeNode> tempList = new ArrayList<>();
//	public void flatten(TreeNode root) {
//		TreeNode result = new TreeNode(0);
//		TreeNode temp = result;
//		add(root);
//		Iterator<TreeNode> iter = tempList.iterator();
//		while (iter.hasNext()) {	
//			temp.right = iter.next();
//			temp.left = null;
//			temp = temp.right;
//		}
//		root = result.right;
//    }
//	public void add(TreeNode root){
//		if (root == null) {
//			return;
//		}
//		tempList.add(root);
//		if (root.left != null ) {
//			add(root.left);
//		}
//		if (root.right != null) {
//			add(root.right);
//		}
//	}
	
	
	public void flatten(TreeNode root) {
        dfs(root);
    }	
    
    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode node = root;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = null;
        root.right = dfs(leftNode);
        while (root.right != null) {
            root = root.right;
        }
        root.right = dfs(rightNode);
        return node;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlattenBinaryTreetoLinkedList t = new FlattenBinaryTreetoLinkedList();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.left = left;
		t.flatten(root);
		System.out.println(root.val + "  " + root.right.val);
	}

}

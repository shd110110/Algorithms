/**
 * Dec 15, 2015
 * Poirot
 * 4:11:09 PM
 * LeetCode
 */
package leetCodeEasy;

import java.util.LinkedList;

/**
 * @author Poirot
 *
 */
public class PathSum {
	
//	public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return false;
//        }
//        if (root.left == null && root.right == null) {
//            return root.val == sum;
//        }
//        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
//    }
	
	
	//second time
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
            return false;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        int tempSum = 0;
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.addFirst(cur);
                tempSum += cur.val;
                cur = cur.left;
            }
            cur = stack.peekFirst();
            if (cur.left == null && cur.right == null && tempSum == sum) {
                return true;
            }
            
            if (cur.right != null && pre != cur.right) {
                cur = cur.right;
            } else {
                pre = cur;
                tempSum -= cur.val;
                stack.removeFirst();
                cur = null;
            } 
        } 
        return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

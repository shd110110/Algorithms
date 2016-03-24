package leetCodeEasy;

import java.util.LinkedList;

/**
 * @author Poirot
 * 2015年6月2日
 */
public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
        if (root == null) {
			return 0;
		}
        if (root.left == null && root.right == null) {
			return 1;
		}
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
	
	public int maxDepth2(TreeNode root) {
		if (root == null)
	        return 0;
	    LinkedList<TreeNode> myStack = new LinkedList<>();
	    LinkedList<Integer> depthStack = new LinkedList<>();
	    if (root != null) 
	    	myStack.push(root);
	    int maxDepth = 0;
	    depthStack.push(0);
	    while (!myStack.isEmpty()) {
	        TreeNode p = myStack.peek();
	        int d = depthStack.peek();
	        if (d > maxDepth) maxDepth = d;
	        myStack.pop();
	        depthStack.pop();
	        if (p.left != null) {
	        	myStack.push(p.left); 
	        	depthStack.push(d + 1);
	        }
	        if (p.right != null) {
	        	myStack.push(p.right); 
	        	depthStack.push(d + 1);
	        }
	    }
	    return maxDepth + 1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

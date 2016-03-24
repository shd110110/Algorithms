/**
 * 2016年3月12日
 * Poirot
 * 下午1:51:56
 * LeetCode
 */
package leetCodeHard;

import java.util.HashMap;

/**
 * @author Poirot
 *
 */
public class HouseRobberIII {
	HashMap<TreeNode, Integer> robRoot = new HashMap<>();
	HashMap<TreeNode, Integer> donotRobRoot = new HashMap<>();
    public int rob(TreeNode root) { 
        return Math.max(rob(root, true), rob(root, false)); 
    }
    
    public int rob(TreeNode root, boolean mark) {
    	if (root == null) {
    		return 0;
    	}
    	if (mark) {
    		if (robRoot.containsKey(root)) {
    			return robRoot.get(root);
    		}
    		int left = rob(root.left, false);
    		int right = rob(root.right, false);
    		robRoot.put(root, root.val + left + right);
    		return root.val + left + right;
    	} else {
    		if (donotRobRoot.containsKey(root)) {
    			return donotRobRoot.get(root);
    		}
    		int left = rob(root.left);
    		int right = rob(root.right);
    		donotRobRoot.put(root, left + right);
			return left + right;
		}
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobberIII t = new HouseRobberIII();
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(1);
		root.left = a;
		root.right = b;
		a.right = c;
		b.right = d;
		System.out.println(t.rob(root));
	}

}

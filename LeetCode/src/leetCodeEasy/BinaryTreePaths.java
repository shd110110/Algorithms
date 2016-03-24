package leetCodeEasy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot
 * 2015年8月17日
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null ) {
			List<String> res = new ArrayList<>();
			return res;
		} 
        if (root.left == null && root.right == null) {
			List<String> res = new ArrayList<>();
			res.add(String.valueOf(root.val));
			return res;
		}
        List<String> res = new ArrayList<>();
         
        if (root.left != null) {
        	List<String> resOfLeft = binaryTreePaths(root.left);
        	for (int i = 0; i < resOfLeft.size(); i++) {
				res.add(String.valueOf(root.val) + "->" + resOfLeft.get(i));
			}
		}
        if (root.right != null) {
        	List<String> resOfright = binaryTreePaths(root.right);
        	for (int i = 0; i < resOfright.size(); i++) {
				res.add(String.valueOf(root.val) + "->" + resOfright.get(i));
			}
		}
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

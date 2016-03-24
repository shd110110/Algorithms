package leetCodeMedium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
//150606
public class ValidateBinarySearchTree {
	
	
	// 先遍历再验证
//	ArrayList<Integer> result  = new ArrayList<Integer>();
//    public boolean isValidBST(TreeNode root) {
//    	if (root == null || (root.left == null && root.right == null)) {
//			return true;
//		}
//        inorderTraversal(root);
//        for (int i = 0; i < result.size()-1; i++) {
//			if (result.get(i) >= result.get(i+1)) {
//				return false;
//			}
//		}
//        return true; 
//    	 
//    }
//    public List<Integer> inorderTraversal(TreeNode root) {
// 		inorder(root);
//		return result;
//	}
//
//	public void inorder(TreeNode root) {
//		if (root == null) {
//			return;
//		} else {
//			inorder(root.left);
//			result.add(root.val);
//			inorder(root.right); 
//			return;
//		}
//	} 
	
	// second solution
	// 回溯
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode cur = stack.pop();
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode pre = stack.pop();
        cur = pre.right;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre.val >= cur.val) {
                return false;
            }
            pre = cur;
            cur = cur.right;
        }
        return true;
    }	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	

}

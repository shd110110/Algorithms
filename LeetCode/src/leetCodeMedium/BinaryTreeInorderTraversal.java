package leetCodeMedium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
//150606
public class BinaryTreeInorderTraversal {
//	List<Integer> result = new ArrayList<Integer>();
// 	public List<Integer> inorderTraversal(TreeNode root) {
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
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

//        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
         
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
            	stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
	}

}

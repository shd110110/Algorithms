package leetCodeMedium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
 

//150606
public class BinaryTreePreorderTraversal {
//	// 递归
//	List<Integer> result = new ArrayList<Integer>();
//	public List<Integer> preorderTraversal(TreeNode root) {
//        preorder(root);
//        return result;
//    }
//	
//	public void preorder(TreeNode root){
//		if (root == null) {
//			return ;
//		}else {
//			result.add(root.val);
//			preorder(root.left);
//			preorder(root.right);
//			return ;
//		}
//	}
	
	// 非递归，用栈
//	public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode cur = stack.pop();
//            res.add(cur.val);
//            if (cur.right != null) {
//                stack.push(cur.right);
//            }
//            if (cur.left != null) {
//                stack.push(cur.left);
//            }
//        }
//        return res;
//    }
	
	// morris none Recursive 
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
         
        while (root != null) {
            res.add(root.val);
            TreeNode leftNode = root.left;
            if (leftNode == null) {
                root = root.right;
            } else {
                while(leftNode.right != null) {
                    leftNode = leftNode.right;
                }
                leftNode.right = root.right;
                root = root.left;
            } 
            
        }
        return res;
    }	
     
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

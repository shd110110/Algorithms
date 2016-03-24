package leetCodeMedium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//150606
public class SymmetricTree {
//	public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//			return true;
//		}
//        return symmetric(root.left, root.right);
//    }
//	public boolean symmetric(TreeNode leftNode, TreeNode rightNode){
//		if (leftNode == null || rightNode == null) {
//			return leftNode == rightNode;
//		}else {
//			if(leftNode.val != rightNode.val) {
//				return false;
//			}else {
//				return symmetric(leftNode.left, rightNode.right) && symmetric(leftNode.right, rightNode.left);
//			}
//			
//		} 
//	}
	
	
	
	// none recursive
    public boolean isSymmetric(TreeNode root) {
        if(root==null)  return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if(root.left!=null){
            if(root.right==null) {
                return false;    
            }
            stack.push(root.left);
            stack.push(root.right);
        } else if(root.right!=null){
            return false;
        }
        

        while(!stack.empty()){
            if(stack.size()%2!=0) {
                return false;
            }  
                
            right = stack.pop();
            left = stack.pop();
            if(right.val!=left.val) {
                return false;
            }
            if(left.left!=null){
                if(right.right==null) {
                    return false;
                }
                stack.push(left.left);
                stack.push(right.right);
            } else if(right.right!=null){
                return false;
            }

            if(left.right!=null){
                if(right.left==null) {
                    return false;
                }
                stack.push(left.right);
                stack.push(right.left);
            } else if(right.left!=null) {
                return false;
            }
        }

        return true;
    }
	
	
	
	 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymmetricTree t = new SymmetricTree();
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(3);
		TreeNode d  = new TreeNode(2);
		root.left = a;
		root.right = b;
		a.left = c;
		b.left = d;
		System.out.println(t.isSymmetric(root));
	}

}

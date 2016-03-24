package leetCodeMedium;

import java.util.LinkedList;

/**
 * @author Poirot
 * 2015年6月21日
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
//	public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return forCall(preorder, 0, preorder.length-1,inorder, 0, inorder.length-1);
//    }
//	public TreeNode forCall(int[] preorder,int begin,int end, int[] inorder,int begin2, int end2){
//		if (begin > end) {
//			return null;
//		}
//		if (begin == end) {
//			return new TreeNode(preorder[begin]);
//		}
//		int rootValue = preorder[begin];
//		TreeNode root = new TreeNode(rootValue);
//		int index = begin2;
//		for (int i = begin2; i <= end2; i++) {
//			if (inorder[i] == rootValue) {
//				index = i;
//				break;
//			}
//		}
//		
//		if (index == begin2) {
//			root.left = null;
//			root.right = forCall(preorder, begin+1, end, inorder, begin2+1, end2);
//		}else if (index == end2) {
//			root.left = forCall(preorder, begin+1, end, inorder, begin2, end2-1);
//			root.right = null;
//		}else {
//			int distance = index - begin2;
//			
//			root.left = forCall(preorder, begin+1, begin+distance, inorder, begin2, index-1);
//			root.right = forCall(preorder,  begin+distance+1, end, inorder, index+1, end2);
//		}
//		
//		return root;
//	}
	
	
	// iterative Solution
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int index = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode cur = stack.peek();
            if (cur.val != inorder[index]) {
                cur.left = new TreeNode(preorder[i]);
                stack.push(cur.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[index]) {
                    cur = stack.pop();
                    index++;
                }
                if (index < inorder.length) {
                    cur.right = new TreeNode(preorder[i]);
                    stack.push(cur.right);
                }
            }
        }
        return root;
    }

	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

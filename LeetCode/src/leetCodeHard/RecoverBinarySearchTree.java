/**
 * 2015��6��24��
 * CH
 */
package leetCodeHard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CH
 *
 */
public class RecoverBinarySearchTree {
	
	// first solution
//	ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
//	public void recoverTree(TreeNode root) {
//		if (root== null || (root.left == null && root.right==null)) {
//			return;
//		}
//        inorderTravel(root);
//        TreeNode[] nodes = new TreeNode[2]; 
//        int k = 0;
//        for (int i = 0; i < temp.size(); i++) {
//			if (i == 0 ) {
//				if (temp.get(i).val > temp.get(i+1).val) {
//					nodes[k++] = temp.get(i);
//				}
//				 
//			}else if (i == temp.size()-1) {
//				if (temp.get(i).val < temp.get(i-1).val) {
//					nodes[k++] = temp.get(i); 
//				} 
//			}else{
//				if ( (temp.get(i).val < temp.get(i-1).val || temp.get(i).val > temp.get(i+1).val) &&(temp.get(i-1).val <temp.get(i+1).val) ) {
//					nodes[k++] = temp.get(i); 
//				} 
//			}
//		}
//        int t = nodes[0].val;
//        nodes[0].val = nodes[1].val;
//        nodes[1].val = t;
//        return;
//    }
//	public void inorderTravel(TreeNode root){ 
//		if (root.left == null && root.right == null) {
//			temp.add(root);
//			return;
//		}
//		if (root.left != null) {
//			inorderTravel(root.left);
//		} 
//		temp.add(root);
//		if (root.right != null) {
//			inorderTravel(root.right);
//		}
//	}
	
	// second Solution 0(n) 
	public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode first = null;
        TreeNode second = null;
        
        TreeNode pre = stack.pop();
        TreeNode cur = pre;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        pre = stack.pop();
        cur = pre.right;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre.val > cur.val && first == null) {
                first = pre;
            } 
            if (pre.val > cur.val) {
                second = cur;
            }
            pre = cur;
            cur = pre.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		RecoverBinarySearchTree t = new RecoverBinarySearchTree();
		t.recoverTree(a);
		System.out.println(a.val);
		System.out.println(b.val);
		System.out.println(c.val);
	}

}

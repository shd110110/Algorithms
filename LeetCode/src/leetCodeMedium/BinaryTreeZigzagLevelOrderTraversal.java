package leetCodeMedium;

import java.util.ArrayDeque; 
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//150607
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
			return result;
		}
        Deque<TreeNode> temp = new ArrayDeque<TreeNode>();
        temp.add(root);
        int lengthOfLvel = temp.size();
        boolean oddOrEven = true; 
        while(!temp.isEmpty()){

        	lengthOfLvel = temp.size();
        	LinkedList<Integer> list = new LinkedList<Integer>();
        	if (oddOrEven) {
        		for (int i = 0; i < lengthOfLvel; i++) {
        			TreeNode p = temp.pop();
        			if (p.left!=null) {
        				temp.add(p.left);
					}
        			if (p.right != null) {
        				temp.add(p.right);
					}
    				list.add(p.val);
    			}
			}else {
				for (int i = 0; i < lengthOfLvel; i++) {
					TreeNode p = temp.pop();
					if (p.left!=null) {
        				temp.add(p.left);
					}
        			if (p.right != null) {
        				temp.add(p.right);
					}
    				list.addFirst(p.val);
    			}
			}
        	result.add(list);
        	oddOrEven = !oddOrEven;
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package leetCodeMedium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//150523
public class BinaryTreeRightSideView {

	public List<Integer> rightSlideViewBFS(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
	    if (root == null)
	        return list;
	    else {
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        q.add(root);
	        while (!q.isEmpty()) {
	            int rowSize = q.size();
	            for (int i = 0; i < rowSize; i++) {
	                TreeNode c = q.poll();
	                if (i == 0)
	                    list.add(c.val);
	                if (c.right != null)
	                    q.add(c.right);
	                if (c.left != null)
	                    q.add(c.left);
	            }
	        }
	        return list;
	    }
	}
	public List<Integer> rightSideView(TreeNode root) {
		if (root == null)
			return (new ArrayList<Integer>());
		if (root.left == null && root.right == null) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(root.val);
			return list;
		}
		List<Integer> left = rightSideView(root.left);
		List<Integer> right = rightSideView(root.right);
		if (right.size() < left.size()) {
			for (int i = right.size(); i < left.size(); i++)
				right.add(left.get(i));
		}
		right.add(0, root.val);
		return right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

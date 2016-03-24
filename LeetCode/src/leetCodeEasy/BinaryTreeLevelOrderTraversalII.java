package leetCodeEasy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Poirot
 * 2015年6月2日
 */
public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}  
        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(root);
        while (!tempQueue.isEmpty()){
        	List<Integer> temp = new ArrayList<>();
        	int size = tempQueue.size();//表示这一层的node数量；
        	for (int i = 0; i < size; i++) {
				TreeNode node = tempQueue.remove();
				temp.add(node.val);
				if (node.left != null) {
					tempQueue.add(node.left);
				}
				if (node.right != null) {
					tempQueue.add(node.right);
				}
			}
        	result.add(temp);
        }
        
        List<List<Integer>> result1 = new ArrayList<>();
        for (int i = result.size()-1; i >= 0; i--) {
			result1.add(result.get(i));
		}
        return result1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

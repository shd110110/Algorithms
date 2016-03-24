package leetCodeMedium;

/**
 * @author Poirot
 * 2015年6月22日
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder)  {
        return forCall(postorder, 0, postorder.length-1,inorder, 0, inorder.length-1);
    }
	public TreeNode forCall(int[] postorder,int begin,int end, int[] inorder,int begin2, int end2){
		if (begin > end) {
			return null;
		}
		if (begin == end) {
			return new TreeNode(postorder[end]);
		}
		int rootValue = postorder[end];
		TreeNode root = new TreeNode(rootValue);
		int index = begin2;
		for (int i = begin2; i <= end2; i++) {
			if (inorder[i] == rootValue) {
				index = i;
				break;
			}
		}
		
		if (index == begin2) {
			root.left = null;
			root.right = forCall(postorder, begin, end-1, inorder, begin2+1, end2);
		}else if (index == end2) {
			root.left = forCall(postorder, begin, end-1, inorder, begin2, end2-1);
			root.right = null;
		}else {
			int distance = index - begin2;
			root.left = forCall(postorder, begin, begin+distance-1, inorder, begin2, index-1);
			root.right = forCall(postorder,  begin+distance, end-1, inorder, index+1, end2);
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

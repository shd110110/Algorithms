package leetCodeHard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot
 * 2015年6月21日
 */
public class UniqueBinarySearchTreesII { 
	//other's idea
//	public List<TreeNode> generateTrees(int n) {
//        List<TreeNode>[] result = new ArrayList[n+1];
//        result[0] = new ArrayList<TreeNode>();
//        result[0].add(null);
//
//        for(int len = 1; len <= n; len++){
//            result[len] = new ArrayList<TreeNode>();
//            for(int j=0; j<len; j++){
//                for(TreeNode nodeL : result[j]){
//                    for(TreeNode nodeR : result[len-j-1]){
//                        TreeNode node = new TreeNode(j+1);
//                        node.left = nodeL;
//                        node.right = clone(nodeR, j+1);
//                        result[len].add(node);
//                    }
//                }
//            }
//        }
//        return result[n];
//    }
//
//    private static TreeNode clone(TreeNode n, int offset){
//        if(n == null)
//            return null;
//        TreeNode node = new TreeNode(n.val + offset);
//        node.left = clone(n.left, offset);
//        node.right = clone(n.right, offset);
//        return node;
//    }
	public List<TreeNode> generateTrees(int n) {
		return forCall(1, n);
    }
	public List<TreeNode> forCall(int m, int n){
        if(m > n) {
            List<TreeNode> result = new ArrayList<TreeNode>();
            result.add(null);
            return result;
        }
        List<TreeNode> roots = new ArrayList<TreeNode>();
        for(int i = m; i <= n; i++){
            List<TreeNode> left = forCall(m, i-1);
            List<TreeNode> right = forCall(i+1, n);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    roots.add(root);
                }
            }

        }   
        return roots;
    } 
//	public TreeNode copyTree(TreeNode root){
//		if (root == null) {
//			return null;
//		}
//		TreeNode copyRoot = new TreeNode(root.val); 
//		if (root.left == null ) {
//			copyRoot.left = copyTree(root.left);
//		}
//		if (root.right == null ) {
//			copyRoot.right = copyTree(root.right);
//		}
//		return copyRoot;
//	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTreesII t = new UniqueBinarySearchTreesII();
		
		System.out.println(t.generateTrees(14).size());
	}

}

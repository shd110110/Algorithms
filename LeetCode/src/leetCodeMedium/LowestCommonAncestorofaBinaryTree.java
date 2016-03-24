/**
 * 
 */
package leetCodeMedium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Poirot
 *
 */
public class LowestCommonAncestorofaBinaryTree { 
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { 
//        if (p == root || q == root || root == null) {
//			return root;
//		} 
//        TreeNode leftSearch = lowestCommonAncestor(root.left, p, q);
//        TreeNode rightSearch = lowestCommonAncestor(root.right, p, q);
//        if (leftSearch == null) {
//			return rightSearch;
//		}else if (rightSearch == null) {
//			return leftSearch;
//		}else {
//			return root;
//		} 
//    } 
    
    
//	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { 
//        if (p == root || q == root || root == null) {
//			return root;
//		} 
//        TreeNode leftSearch = lowestCommonAncestor(root.left, p, q);
////        TreeNode rightSearch = lowestCommonAncestor(root.right, p, q);
//        if (leftSearch == null) {
//			return lowestCommonAncestor(root.right, p, q);
//		}else {
//			TreeNode rightSearch = lowestCommonAncestor(root.right, p, q);
//			if (rightSearch == null) { 
//				return leftSearch;
//			}else {
//				return root;
//			} 
//		}
//    } 
	 
    
//    public class Frame {
//        TreeNode node;
//        Frame parent;
//        ArrayList<TreeNode> subs;
//        public Frame(TreeNode node, Frame parent) {
//			// TODO Auto-generated constructor stub
//        	this.node = node;
//        	this.parent = parent;
//        	subs = new ArrayList<>();
//		}
//    };
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { 
//        Frame answer = new Frame(null, null);
//        LinkedList<Frame> stack = new LinkedList<>();
//        stack.push(new Frame(root, answer));
//        while (!stack.isEmpty()) {
//            Frame top = stack.peek(), parent = top.parent;
//            TreeNode node = top.node;
//            if (node == null || node == p || node == q) {
//                parent.subs.add(node);
//                stack.pop();
//            } else if (top.subs.isEmpty()) {
//                stack.push(new Frame(node.right, top));
//                stack.push(new Frame(node.left, top));
//            } else {
//                TreeNode left = top.subs.get(0), right = top.subs.get(1);
//                parent.subs.add(left == null ? right : right == null ? left : node);
//                stack.pop();
//            }
//        }
//        return answer.subs.get(0);
//    }
    
    
	// Find two paths from the root to p
	// then compare the two paths
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        if(p==null || q==null)  return null;
        ArrayList<TreeNode> p_path = new ArrayList<TreeNode>();
        ArrayList<TreeNode> q_path = new ArrayList<TreeNode>();
        findPath(root, p, p_path);
        findPath(root, q, q_path);
        int min_len = Math.min(p_path.size(), q_path.size());
        int LCA = 0;
        for(int i=0; i<min_len; i++){
            if(p_path.get(i)==q_path.get(i))
                LCA = i;
        }
        return p_path.get(LCA);
    }
	
    public static boolean findPath(TreeNode root, TreeNode n1, List<TreeNode> path){
        if(root == null)
            return false;
        path.add(root);
        if(root == n1)
            return true;
        if(findPath (root.left, n1, path) || findPath(root.right, n1, path))
            return true;
        path.remove(path.size() - 1);
        return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LowestCommonAncestorofaBinaryTree t = new LowestCommonAncestorofaBinaryTree();
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		root.left = root2;
		root.right = root3;
		System.out.println(t.lowestCommonAncestor(root, root2, root3).val);
	}

}

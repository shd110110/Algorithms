/**
 * 2015年11月20日
 * Poirot
 */
package leetCodeMedium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Poirot
 *
 */
public class SerializeandDeserializeBinaryTree {
	public class Codec { 
		// Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        if (root == null) {
	            return null;
	        }
	        LinkedList<TreeNode> level = new LinkedList<>();
	        StringBuilder res = new StringBuilder();
	        level.add(root);
	        while (!level.isEmpty()) {
	            int size = level.size();
	            for (int i = 0; i < size; i++) {
	                TreeNode node = level.removeFirst();
	                if (node == null) {
	                    res.append("X#");
	                } else {
	                    res.append(node.val + "#");
	                    level.add(node.left);
	                    level.add(node.right);
	                }
	            }
	            res.append("@");
	        }
	        return res.toString();
	    } 
	    
	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        if (data == null) {
	            return null;
	        }
	        String[] levelStrings = data.split("@"); 
	        TreeNode root = new TreeNode(Integer.valueOf(levelStrings[0].split("#")[0]));
	        LinkedList<TreeNode> level = new LinkedList<>();
	        level.add(root);
	        int depth = 1; 
	        while (!level.isEmpty() && depth < levelStrings.length) {
	        	 
	            String[] levelValues = levelStrings[depth].split("#");
	            int size = level.size(); 
	            int sonIndex = 0;
	            for (int i = 0; i < size; i++) {
	            	
	                TreeNode node = level.removeFirst();
	                if (node != null) {
	                	if (levelValues[sonIndex].equals("X") ) {
	                        node.left = null;
	                    } else {
	                        node.left = new TreeNode(Integer.valueOf(levelValues[sonIndex]));
	                        level.add(node.left);
	                    }
	                    sonIndex++;
	                    if (levelValues[sonIndex].equals("X") ) {
	                        node.right = null;
	                    } else {
	                        node.right = new TreeNode(Integer.valueOf(levelValues[sonIndex]));
	                        level.add(node.right);
	                    }
	                    sonIndex++;
	                }
	            }
	            depth++;
	        }
	        return root;  
	    }


	    // MV Solution
//	    private static final String spliter = ",";
//	    private static final String NN = "X";
//
//	    // Encodes a tree to a single string.
//	    public String serialize(TreeNode root) {
//	        StringBuilder sb = new StringBuilder();
//	        buildString(root, sb);
//	        return sb.toString();
//	    }
//
//	    private void buildString(TreeNode node, StringBuilder sb) {
//	        if (node == null) {
//	            sb.append(NN).append(spliter);
//	        } else {
//	            sb.append(node.val).append(spliter);
//	            buildString(node.left, sb);
//	            buildString(node.right,sb);
//	        }
//	    }
//	    // Decodes your encoded data to tree.
//	    public TreeNode deserialize(String data) {
//	        Deque<String> nodes = new LinkedList<>();
//	        nodes.addAll(Arrays.asList(data.split(spliter)));
//	        return buildTree(nodes);
//	    }
//
//	    private TreeNode buildTree(Deque<String> nodes) {
//	        String val = nodes.remove();
//	        if (val.equals(NN)) return null;
//	        else {
//	            TreeNode node = new TreeNode(Integer.valueOf(val));
//	            node.left = buildTree(nodes);
//	            node.right = buildTree(nodes);
//	            return node;
//	        }
//	    }    
	 
	}
	
//	public class Codec { 
//
//	    // Encodes a tree to a single string.
//	    public String serialize(TreeNode root) {
//	        StringBuilder sb = new StringBuilder();
//	        buildString(root, sb);
//	        return sb.toString();
//	    }
//
//	    private void buildString(TreeNode node, StringBuilder sb) {
//	        if (node == null) {
//	            sb.append("#").append(",");
//	        } else {
//	            sb.append(node.val).append(",");
//	            buildString(node.left, sb);
//	            buildString(node.right,sb);
//	        }
//	    }
//	    // Decodes your encoded data to tree.
//	    public TreeNode deserialize(String data) {
//	        Deque<String> nodes = new LinkedList<>();
//	        nodes.addAll(Arrays.asList(data.split(",")));
//	        return buildTree(nodes);
//	    }
//
//	    private TreeNode buildTree(Deque<String> nodes) {
//	        String val = nodes.remove();
//	        if (val.equals("#")) return null;
//	        else {
//	            TreeNode node = new TreeNode(Integer.valueOf(val));
//	            node.left = buildTree(nodes);
//	            node.right = buildTree(nodes);
//	            return node;
//	        }
//	    }
//	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		root.right = a;
		a.right = b;
		SerializeandDeserializeBinaryTree t = new SerializeandDeserializeBinaryTree();
		Codec codec = t.new Codec();
		System.out.println(codec.serialize(root));
		
		TreeNode node = codec.deserialize(codec.serialize(root));
		System.out.println(node.val);
		System.out.println(node.right.val);
		System.out.println(node.right.right.val);
	}

}

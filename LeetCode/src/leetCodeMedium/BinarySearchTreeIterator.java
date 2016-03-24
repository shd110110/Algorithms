package leetCodeMedium;
  
import java.util.LinkedList;
import java.util.Stack;
//150607
public class BinarySearchTreeIterator {
//	public class BSTIterator {
//		public Stack<TreeNode> nextSmallestStack;
//	    public BSTIterator(TreeNode root) {
//	    	nextSmallestStack = new Stack<TreeNode>();
//	        putToNextSmallestStack(root);
//	    }
//	    public void putToNextSmallestStack(TreeNode root){
//	    	if (root == null) {
//				return;
//			}else {
//				nextSmallestStack.add(root);
//				TreeNode temp = root.left;
//				while(temp != null){
//					nextSmallestStack.add(temp);
//					temp = temp.left;
//				}
//			}
//	    }
//
//	    /** @return whether we have a next smallest number */
//	    public boolean hasNext() {
//	        return !nextSmallestStack.isEmpty();
//	    }
//
//	    /** @return the next smallest number */
//	    public int next() {
//	        TreeNode smallest = nextSmallestStack.pop();
//	        putToNextSmallestStack(smallest.right);
//	        return smallest.val;
//	    }
//	}
	
	
	public class BSTIterator {
        TreeNode root;
        public BSTIterator(TreeNode root) {
            this.root = root;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
        	System.out.println(true);
            return root != null;
        }

        /** @return the next smallest number */
        public int next() { 
            while (root.left != null) {
            	TreeNode leftNode = root.left;
                while (leftNode.right != null) {
                    leftNode = leftNode.right;
                } 
                leftNode.right = root;
                TreeNode temp = root;
                root = root.left;
                temp.left = null;
                
            }
            int res = root.val;
            root = root.right;
            return res;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(6);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(1);
		
		
		
		LinkedList<Integer> level = new LinkedList<>();
		  
		root.right = b;
		a.left = c;
		a.right = d;
		c.left = e;
		BinarySearchTreeIterator t = new BinarySearchTreeIterator();
		BSTIterator bstIterator = t.new BSTIterator(root);
		while (bstIterator.hasNext()) {
			System.out.println(bstIterator.next());
		}
	}

}

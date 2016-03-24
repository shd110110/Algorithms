package leetCodeMedium;

/**
 * @author Poirot
 * 2015年7月2日
 */
public class KthSmallestElementinaBST {
	int result=0 ;
	int i = 0;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallest2(root, k);
        return result;
    }
    public void kthSmallest2(TreeNode node, int k){ 
    	if (node == null) {
			return;
		}
    	if (node.left == null && node.right== null) {
    		i++;
    		if (i == k) {
    			result = node.val; 
    		}
			return;
		}else {
			kthSmallest(node.left, k);
			i++;
			if (i == k) {
				result = node.val;
				return;
			}
			kthSmallest(node.right, k);
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthSmallestElementinaBST t = new KthSmallestElementinaBST();
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		System.out.println(t.kthSmallest(root, 1));
	}

}

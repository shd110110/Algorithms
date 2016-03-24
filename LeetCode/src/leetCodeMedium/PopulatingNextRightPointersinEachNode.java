/**
 * 2015Äê6ÔÂ19ÈÕ
 * CH
 */
package leetCodeMedium;

import java.util.LinkedList;

/**
 * @author CH
 *
 */
public class PopulatingNextRightPointersinEachNode {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return ;
		}
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while (!queue.isEmpty()){
        	TreeLinkNode firstOfLevel = queue.removeFirst();
        	int length = queue.size();
        	if (firstOfLevel.left != null) {
				queue.add(firstOfLevel.left);
			}
        	if (firstOfLevel.right != null) {
				queue.add(firstOfLevel.right);
			}
        	for (int i = 0; i < length; i++) {
        		firstOfLevel.next = queue.removeFirst();
        		firstOfLevel = firstOfLevel.next;
        		if (firstOfLevel.left != null) {
    				queue.add(firstOfLevel.left);
    			}
            	if (firstOfLevel.right != null) {
    				queue.add(firstOfLevel.right);
    			}
			}
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

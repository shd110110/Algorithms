package leetCodeEasy;

/**
 * @author Poirot
 * 2015年7月16日
 */
public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        if (node.next == null) {
			node = null;
		}else {
			node.val = node.next.val;
			node.next = node.next.next;
		}
    	return;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

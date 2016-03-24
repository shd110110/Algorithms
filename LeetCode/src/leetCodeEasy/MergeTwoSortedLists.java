/**
 * 2015年11月29日
 * Poirot
 */
package leetCodeEasy;

/**
 * @author Poirot
 *
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		
		ListNode node = new ListNode(0);
		ListNode res = node;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				node.next = l1;
				node = node.next;
				l1 = l1.next;
			} else {
				node.next = l2;
				node = node.next;
				l2 = l2.next;
			}
		}
		if (l1 != null) {
			node.next = l1;
		} else {
			node.next = l2;
		}
		return res.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package leetCodeMedium;

import java.util.HashSet;

/**
 * @author Poirot
 * 2015年6月10日
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		HashSet<ListNode> set = new HashSet<ListNode>();
		ListNode temp = head;
		while (temp != null){
			if (!set.add(temp)) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

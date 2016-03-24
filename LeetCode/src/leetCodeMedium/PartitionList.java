package leetCodeMedium;
 

/**
 * @author Poirot 2015年6月9日
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode firstSmall = null;
		ListNode firstBigger = null;
		ListNode firstBiggerCopy = null;
		ListNode result = null;
		ListNode cur = head;
		while(cur!=null){
			if (cur.val < x) {
				if (firstSmall == null) {
					firstSmall = cur;
					result = firstSmall;
				}else {
					firstSmall.next = cur;
					firstSmall = firstSmall.next;
				}
			}else {
				if (firstBigger == null) {
					firstBigger = cur;
					firstBiggerCopy = cur;
				}else {
					firstBigger.next = cur;
					firstBigger = firstBigger.next;
				}
			}
			cur = cur.next;
		}
		if (result == null) {
			return firstBiggerCopy;
		}
		if (firstBiggerCopy == null) {
			firstSmall.next = null;
			return result;
		}
		firstSmall.next = firstBiggerCopy;
		firstBigger.next = null;
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

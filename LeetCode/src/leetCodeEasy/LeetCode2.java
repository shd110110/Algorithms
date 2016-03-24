package leetCodeEasy;

public class LeetCode2 {

	// public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	// if (l2 == null)
	// return l1;
	// else if (l1 == null) {
	// return l2;
	// }
	// int tempCarry = 0, a = 0;
	// ListNode head1 = l1;
	// ListNode pre1 = l1;
	// ListNode pre2 = l2;
	// tempCarry = (l1.val + l2.val + tempCarry) / 10;
	// l1.val = (l1.val + l2.val + a) % 10;
	// l1 = l1.next;
	// l2 = l2.next;
	//
	// while (l1 != null && l2 != null) {
	// a = tempCarry;
	// tempCarry = (l1.val + l2.val + a) / 10;
	// l1.val = (l1.val + l2.val + a) % 10;
	// l1 = l1.next;
	// pre1 = pre1.next;
	// l2 = l2.next;
	// pre2 = pre2.next;
	// }
	// if (l1 == null && l2 == null) {
	// if (tempCarry>0) {
	// ListNode end = new ListNode(tempCarry);
	// pre1.next = end;
	// }
	// return head1;
	// } else {
	// if (l1 == null) {
	// pre1.next = l2;
	// l1 = l2;
	// }
	// while (l1 != null && l1.val + tempCarry > 9) {
	// a = tempCarry;
	// tempCarry = (l1.val + a) / 10;
	// l1.val = (l1.val + a) % 10;
	// pre1 = pre1.next;
	// l1 = l1.next;
	// }
	// if (l1 == null && tempCarry > 0) {
	// ListNode end = new ListNode(tempCarry);
	// pre1.next = end;
	// }
	// if (l1!=null) {
	// l1.val+=tempCarry;
	// }
	// return head1;
	// }
	// }
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbersWithCarry(l1, l2, 0);
	}

	public static int maxProduct(int[] A) {
		return 0;
	}

//	public static void rotate(int[] nums, int k) {
//		k = k%(nums.length);
//		if ( k == 0) {
//			return;
//		}
//		int temp = 0;
//		for (int i = 0; i < k; i++) {
//			
//		}
//	}

	ListNode addTwoNumbersWithCarry(ListNode l1, ListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0)
			return null;

		int sum = carry;
		if (l1 != null)
			sum += l1.val;
		if (l2 != null)
			sum += l2.val;

		ListNode result = new ListNode(sum % 10);
		result.next = addTwoNumbersWithCarry(l1 == null ? null : l1.next,
				l2 == null ? null : l2.next, sum >= 10 ? 1 : 0);
		return result;
	}
}

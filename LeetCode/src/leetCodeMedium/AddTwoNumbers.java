package leetCodeMedium;

/**
 * @author Poirot
 * 2015年9月14日
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	// solution 1
    	ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;

        // solution 2
//        int left = 0;
//        ListNode dummy = new ListNode(0), tail = dummy;
//
//        // iterate two list, add each position until 2 lists are finished && left equals to 0
//        while(!(l1 == null && l2 == null && left == 0)){
//            // is number1 finished?
//            int add1 = l1 != null ? l1.val : 0;
//            // is number2 finished?
//            int add2 = l2 != null ? l2.val : 0;
//            int sum = add1 + add2 + left;
//            left = sum / 10;
//            ListNode newNode = new ListNode(sum % 10);
//            tail.next = newNode;
//            tail = newNode;
//
//            if(l1 != null) l1 = l1.next;
//            if(l2 != null) l2 = l2.next;
//        }
//
//        return dummy.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

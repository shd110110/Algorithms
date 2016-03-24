package leetCodeMedium;


public class SwapNodesinPairs {
	//second
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode even = head.next;
        ListNode odd = head; 
        ListNode res = pre;
        while (pre.next != null && pre.next.next != null) {
            even = pre.next.next;
            odd = pre.next; 
            odd.next = even.next;
            even.next = odd;
            pre.next = even;
            pre = pre.next.next;
        }
        return res.next;
    }
    
	//first
//	public static ListNode swapPairs(ListNode head) {
//		if (head == null || head.next == null)
//            return head;
//
//		
//		ListNode temp = head;
//		ListNode pre = new ListNode(0);
//		pre.next = temp;
//		head = head.next;
//		
//		while(temp != null && temp.next != null)
//		{
//			
//			ListNode second = temp.next;
//			
//			temp.next = second.next;
//			
//			second.next = temp;
//			pre.next = second;
//			pre = temp;
//			temp = temp.next;
//			
//		}
//		if (temp!=null) {
//			temp.next = null;
//		}
//		return head;
//    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapNodesinPairs t = new SwapNodesinPairs();
		ListNode A11 = new ListNode(1);
		ListNode A12 = new ListNode(2);
		ListNode A13 = new ListNode(3);
		ListNode A14 = new ListNode(4);
		A11.next = A12;
		A12.next = A13;
		A13.next = A14;
		A11 = t.swapPairs(A11);
		while(A11!=null){
			System.out.println(A11.val);
			A11 = A11.next;
		}
		
		
	}

}

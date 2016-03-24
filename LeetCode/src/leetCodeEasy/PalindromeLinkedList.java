/**
 * 2015Äê7ÔÂ10ÈÕ
 * CH
 */
package leetCodeEasy; 
/**
 * @author CH
 *
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next==null) {
			return true;
		}
        ListNode printHead = head;
        while (printHead != null){
        	System.out.print(printHead.val + "  ");
        	printHead = printHead.next;
        }
        System.out.println(); 
        
        
        ListNode end = head;
        int size = 1;
        while (end.next!=null){
        	end = end.next;
        	size++;
        }
        if (size == 2) {
			return head.val == head.next.val;
		}
        ListNode reverseEnd = null;
        ListNode left = head;
        ListNode right = head.next;
        ListNode medium = left.next;
        if (size%2==1) { 
			right = right.next;
		} 
        
        for (int i = 0; i < size/2 -1; i++) {
        	
        	ListNode rest = left.next;
			left.next = reverseEnd;
			reverseEnd = left;
			left = rest;
			medium = left.next;
			right = right.next;
		} 
        left.next = reverseEnd;
        boolean result = true;
        ListNode a = left;
        ListNode b = right;
        
        while (a!=null){
        	if (a.val!=b.val) {
				result = false;
			}
        	a = a.next;
        	b = b.next;
        }
        ListNode copy = left;
        reverseEnd = null;
        while (left!=null){
        	ListNode rest = left.next;
        	left.next = reverseEnd;
        	reverseEnd = left;
        	left = rest;
        }
        copy.next = medium;
//        printHead = head;
//        while (printHead != null){
//        	System.out.print(printHead.val + "  ");
//        	printHead = printHead.next;
//        }
//        System.out.println();
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeLinkedList t = new PalindromeLinkedList();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(3);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		System.out.println(t.isPalindrome(a));
	}

}

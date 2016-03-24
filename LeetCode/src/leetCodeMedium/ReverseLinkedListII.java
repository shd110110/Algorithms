package leetCodeMedium;

/**
 * @author Poirot
 * 2015年6月9日
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		int i = 1;
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode first = head;
		while (i < m){
			
			first = first.next;
			pre = pre.next;
			i++;
		}
//		System.out.println(first.val);
//		System.out.println(i);
		ListNode reverse = null;
		ListNode lastOfReverse = first;
		while (i <= n){
			ListNode temp = first.next;
			first.next = reverse;
			reverse = first;
			first = temp;
			i++;
		}
		lastOfReverse.next = first;
		pre.next = reverse;
		if (m == 1) {
			return reverse;
		}else {
			return head;
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node.next = node2;
		node2.next = node3;
		ReverseLinkedListII t = new ReverseLinkedListII();
		ListNode  test = t.reverseBetween(node,2,3);
		while (test != null){
			System.out.println(test.val);
			test = test.next;
		}
	}

}

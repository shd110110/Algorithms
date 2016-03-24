package leetCodeEasy;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		
		if(head == null){
			return head;
		}else {
			ListNode pre = new ListNode(0);
			pre.next = head;
			ListNode result = pre;
			while(head!=null){
				if(head.val == val){
					pre.next = head.next;
					head = head.next;
				}else {
					pre = head;
					head = head.next;
				}
			}
			return result.next ;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

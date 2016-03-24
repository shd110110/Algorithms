package leetCodeEasy;

//150522
public class ReverseLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode resultHead = null;
		ListNode tempNode = null;
		while (head != null){
			tempNode = head;
			head = head.next;
			tempNode.next = resultHead;
			resultHead = tempNode;
		} 
		return resultHead;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

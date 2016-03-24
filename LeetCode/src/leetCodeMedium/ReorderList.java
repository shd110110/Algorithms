package leetCodeMedium;

/**
 * @author Poirot
 * 2015年6月9日
 */
public class ReorderList {
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
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
            return;
		int length = 0;
		ListNode t = head;
		while (t != null){
			length ++;
			t = t.next;
		}
		int halfLength = length/2;
		//System.out.println(halfLength);
		t = head;
		for (int i = 0; i < halfLength-1; i++) {
			t = t.next;
		}
		
		ListNode oddHead = head;
		if (length%2 == 1) {
			t = t.next;
		}
		ListNode evenHead = reverseList(t.next);
		
		t.next = null;
		ListNode temp = oddHead;
		int i = 0;
		while(i < halfLength){
			oddHead = oddHead.next;
			temp.next = evenHead;
			evenHead = evenHead.next;
			temp = temp.next;
			temp.next = oddHead;
			temp = oddHead;
			i++;
		}
		if (length % 2 == 1) {
			oddHead.next = null;
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		ReorderList reorderList = new ReorderList();
		reorderList.reorderList(node1);
		ListNode temp = node1;
		while(temp!=null){
			System.out.println(temp.val);
			temp = temp.next;
		}
		
	}

}

package leetCodeMedium;

/**
 * @author Poirot
 * 2015年6月9日
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
			return head;
		}
        ListNode result = head;
        ListNode t = head.next;
        result.next = null;
        ListNode tCopy = t;
        while (t != null){
        	tCopy = t.next;
        	t.next = null;
        	result = insertOneNode(result, t);
        	t = tCopy;
        }
        return result;
    }
	public ListNode insertOneNode(ListNode head, ListNode temp){
		if (temp == null) {
			return head;
		}
		if (head == null) {
			return temp;
		}
		ListNode t = head;
		
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode result = pre;
		while(t != null && t.val < temp.val){
			t = t.next;
			pre = pre.next;
		}
		if (t == null) {
			pre.next = temp;
			temp.next = null;
		}else {
			pre.next = temp;
			temp.next = t;
		}
		return result.next;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(9);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(100);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		//ListNode node7 = new ListNode(0);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		InsertionSortList t = new InsertionSortList();
		ListNode temp = t.insertionSortList(node1);

		while(temp!=null){
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

}

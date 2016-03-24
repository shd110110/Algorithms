package leetCodeHard; 
//150604
public class ReverseNodesinkGroup {
	//second
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 1) {
			return head;
		}
		int length = 0;
		ListNode node = head;
		while (node != null) {
			length++;
			node = node.next;
		}
		int circle = length / k; // 
		ListNode pre = new ListNode(0);
		pre.next = head; // always the first node of every k node,also means the first node of every section   
						   
		node = head; // used to travel the list
		
		ListNode res = pre; // to record the pre node of the result node
							// 1->2->3->4->5->6->7->8->9->10->11 k = 4 , 0 0->1  0->2->1  0->3->2->1  0->4->3->2->1  0->4->3->2->1->5   0->4->3->2->1->6->5 and so on
		for (int i = 0; i < circle; i++) {
			ListNode last = node;
			for (int j = 0; j < k; j++) {
				ListNode temp = node.next;
				node.next = pre.next;
				pre.next = node;
				node = temp;
			}
			pre = last;
		}
		pre.next = node;
		return res.next;
    }
	
//	public static ListNode reverseKGroup(ListNode head, int k) {
//		if (head == null) {
//			return head;
//		}
//        ListNode result = null;
//        ListNode tempHead = head; 
//        ListNode currentNode = head;
//        int i = 0;
//        while(i < k && currentNode!=null){
//        	currentNode = currentNode.next;
//        	i++;
//        }
//        if (i < k) {
//			return tempHead;
//		}else {
//			ListNode t = tempHead;
//			ListNode tmpNode = null;
//			ListNode node = null;
//			while (tempHead != currentNode){
//				node = tempHead;
//				tempHead = tempHead.next;
//				node.next = tmpNode;
//				tmpNode = node;	
//			}
//			t.next = reverseKGroup(currentNode, k);
//			result = node;
//		}  
//        return result;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = null;
		ListNode r = reverseKGroup(head, 8);
		while (r!=null){
			System.out.println(r.val);
			r = r.next;
		}
	}

}

package leetCodeMedium;

import java.util.HashSet;
//150609
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		// ����һ�� ���ƻ��ṹ
		// ListNode p,q;
		// p=head;
		// if(p== null)
		// return false;
		// if(p.next == null)
		// return false;
		// while(p.next!= null){
		// q=p.next;
		// p.next=p;
		// if(p==q) return true;
		// else p=q;
		// }
		// return false;

		// ������
//		if (head == null || head.next == null) {
//			return false;
//		}
//
//		ListNode slowPointer = head.next;
//		ListNode fastPointer = head.next.next;
//
//		while ((slowPointer != null && fastPointer != null)) {
//
//			if (slowPointer == fastPointer) {
//				return true;
//			}
//			slowPointer = slowPointer.next;
//
//			if (fastPointer.next != null) {
//				fastPointer = fastPointer.next.next;
//			} else {
//				fastPointer = null;
//			}
//
//		}
//		return false;
		if (head == null || head.next == null) {
			return false;
		}
		HashSet<ListNode> set = new HashSet<ListNode>();
		ListNode temp = head;
		while (temp != null){
			if (!set.add(temp)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

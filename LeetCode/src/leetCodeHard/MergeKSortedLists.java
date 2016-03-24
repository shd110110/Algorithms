package leetCodeHard;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {
	
	//O(n^2log(n)) my idea
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
			return null;
		} 
		if (lists.length == 1) {
			return lists[0];
		}
		return divideAndConquer(lists, 0, lists.length - 1);
    }
	public ListNode divideAndConquer(ListNode[] lists, int begin, int end) {
		if (begin < end) {
			int medium = (begin + end) / 2;
			return mergeTwoLists(divideAndConquer(lists, begin, medium), divideAndConquer(lists, medium + 1, end));
		} else {
			return lists[begin];
		}
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		
		ListNode node = new ListNode(0);
		ListNode res = node;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				node.next = l1;
				node = node.next;
				l1 = l1.next;
			} else {
				node.next = l2;
				node = node.next;
				l2 = l2.next;
			}
		}
		if (l1 != null) {
			node.next = l1;
		} else {
			node.next = l2;
		}
		return res.next;
    }

	// O(n^3)
//	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		if (l1 == null) {
//			return l2;
//		}else if (l2 == null) {
//			return l1;
//		}
//		ListNode result = new ListNode(0);
//		ListNode p = result;
//		while (l1 != null && l2 != null) {
//			if (l1.val < l2.val) {
//				p.next = l1;
//				l1 = l1.next;
//			} else {
//				p.next = l2;
//				l2 = l2.next;
//			}
//			p = p.next;
//		}
//		if (l1 == null) {
//			p.next = l2;
//		} else {
//			p.next = l1;
//		}
//		return result.next;
//	}
//
//	public static ListNode mergeKLists(List<ListNode> lists) {
//		if (lists.size() == 0) {
//			return null;
//		}
//		ListNode tempNode1 = null;
//		ListNode tempNode2 = null;
//		while (lists.size() > 1) {
//			for (int i = 0; i < lists.size()/2; i++) {
//				tempNode1 = lists.remove(i);
//				tempNode2 = lists.remove(i);
//				lists.add(mergeTwoLists(tempNode1, tempNode2));
//			}
//		}
//		return lists.get(0);
//	}

	public static void main(String[] args) {
		List<ListNode> test = new ArrayList<ListNode>();
		ListNode A11 = new ListNode(1);
		ListNode A12 = new ListNode(2);
		ListNode A13 = new ListNode(9);
		A11.next = A12;
		A12.next = A13;
		test.add(A11);
		while(A11!=null){
			System.out.println(A11.val);
			A11 = A11.next;
		}
		
		ListNode B11 = new ListNode(3);
		ListNode B12 = new ListNode(5);
		ListNode B13 = new ListNode(8);
		B11.next = B12;
		B12.next = B13;
		test.add(B11);
		
		ListNode C11 = new ListNode(5);
		ListNode C12 = new ListNode(6);
		ListNode C13 = new ListNode(9);
		C11.next = C12;
		C12.next = C13;
		test.add(C11);
		
//		ListNode r = mergeKLists(test);
//		while(r!=null){
//			System.out.println(r.val);
//			r = r.next;
//		}
	}
}

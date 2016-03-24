package leetCodeMedium;

/**
 * @author Poirot
 * 2015年6月9日
 */
public class SortList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
		ListNode p = result;
		while(l1!=null && l2!=null)
		{
			if (l1.val<l2.val) {
				p.next = l1;
				l1 = l1.next;
			}else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 == null) {
			p.next = l2;
		}else {
			p.next = l1;
		}
		return result.next;
    }
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
			return head;
		}
        int length = 0;
        ListNode temp = head;
        while(temp != null){
        	length++;
        	temp = temp.next;
        }
        temp = head;
        int medium = length /2;
        for (int i = 1; i < medium; i++) {
			temp = temp.next;
		}
        ListNode list2 = temp.next;
        temp.next = null;
        ListNode list1 = head;
        list1 = sortList(list1);
        list2 = sortList(list2);
        return mergeTwoLists(list1, list2);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

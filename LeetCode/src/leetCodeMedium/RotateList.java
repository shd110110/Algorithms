package leetCodeMedium;
//150606
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
        	return head;
        }
        int length = 1;
        ListNode last = head;
        while(last.next !=null){
        	last = last.next;
        	length++;
        }
        k = length- k%length;
        if (k == length) {
			return head;
		}
        
        ListNode temp = head;
        int index = 1;
        while(index < k){
        	temp = temp.next;
        	index++;
        }
        ListNode result = temp.next;
        temp.next = null;
        last.next = head;
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

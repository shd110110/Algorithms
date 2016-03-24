package leetCodeEasy;

import java.util.Arrays;

public class SumClosest {
	
	public static int threeSumClosest(int[] num, int target) {
		int result = num[0]+num[1]+num[num.length-1];
		Arrays.sort(num);
		
		for (int i = 0; i < num.length-2; i++) {
			int begin = i+1;
			int end = num.length-1;
			int sum = num[i]+num[begin]+num[end];
			while (begin<end){
				sum = num[i]+num[begin]+num[end];
				if (sum<target) {
					begin++;
				} else {
					end--;
				}
				if (Math.abs(sum-target)<Math.abs(result-target)) {
					result = sum;
				}
			}
		}
		return result;
    }
	

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null ||head.next == null) {
			return head;
		}
        
        ListNode prev = head;
        ListNode current = head.next;
        ListNode result = new ListNode(0);
        result.next = prev;
        head = result;
        if (prev.val == current.val) {
			
		}
        while (current!=null){
        	while (current!=null && current.val == prev.val ){
        		current = current.next;
        	}
        	if (current == null) {
        		result.next = null;
				break;
			}
        	if (prev.next == current) {
        		result = prev;
				prev = current;
				current = current.next;
			}else {
				prev = current;
				result.next = prev;
				current = current.next;
			}
        }
        return head.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {-1,2,1,-4};
		System.out.println(threeSumClosest(test, 1));
	}

}

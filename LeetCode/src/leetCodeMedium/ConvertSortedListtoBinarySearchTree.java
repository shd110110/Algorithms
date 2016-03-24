package leetCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot 2015年7月2日
 */
public class ConvertSortedListtoBinarySearchTree {
	// Recursive BST construction using slow-fast traversal on linked list
	// O(nlog(n))
//	public TreeNode sortedListToBST(ListNode head) {
//	    if(head == null)
//	        return null;
//	    ListNode fast = head;
//	    ListNode slow = head;
//	    ListNode prev =null; 
//	    while(fast != null && fast.next != null)
//	    {
//	        fast = fast.next.next;
//	        prev =slow;
//	        slow=slow.next;
//	    }
//	    TreeNode root = new TreeNode(slow.val);
//	    if(prev != null)
//	        prev.next = null;
//	    else
//	        head  = null;
//
//	    root.left = sortedListToBST(head);
//	    root.right = sortedListToBST(slow.next);
//	    return root;
//	}

	
	
	//most vote 0(N) 
	private ListNode node;
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		int size = 0;
		ListNode runner = head;
		node = head;

		while (runner != null) {
			runner = runner.next;
			size++;
		}
		return constructToBSTFromInsection(0, size - 1);
	}

	public TreeNode constructToBSTFromInsection(int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode left = constructToBSTFromInsection(start, mid - 1);
		TreeNode treenode = new TreeNode(node.val);
		treenode.left = left;
		node = node.next;
		TreeNode right = constructToBSTFromInsection(mid + 1, end);
		treenode.right = right;
		return treenode;
	}

	
	// My first Solution 0(n) time O(n) space
//	public TreeNode sortedListToBST(ListNode head) {
//		if (head == null) {
//			return null;
//		}
//		ListNode node = head;
//		ArrayList<Integer> list = new ArrayList<>();
//		while (node != null) {
//			list.add(node.val);
//			node = node.next;
//		}
//		return sortedListToBST2(list, 0, list.size() - 1);
//	}
//
//	public TreeNode sortedListToBST2(List<Integer> nums, int begin, int end) {
//		if (begin == end) {
//			return new TreeNode(nums.get(begin));
//		}
//		int medium = (begin + end) / 2;
//		TreeNode node = new TreeNode(nums.get(medium));
//		if (medium - 1 >= begin) {
//			node.left = sortedListToBST2(nums, begin, medium - 1);
//		}
//		if (medium + 1 <= end) {
//			node.right = sortedListToBST2(nums, medium + 1, end);
//		}
//		return node;
//	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

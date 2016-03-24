/**
 * 2016年1月8日
 * Poirot
 * 上午1:51:10
 * LeetCode
 */
package leetCodeHard;

import java.util.LinkedList;

/**
 * @author Poirot
 *
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
			return nums;
		}
        int[] res = new int[nums.length - k + 1];
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> indexList = new LinkedList<>();
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			while (!list.isEmpty() && list.peek() <= nums[i]) {
				list.pop();
				indexList.pop();
			}
			list.push(nums[i]);
//			System.out.println(list.toString());
			indexList.push(i);
			if (i >= k - 1) {
				res[index++] = list.peekLast();
				if (i - indexList.peekLast() == k - 1) {
					list.removeLast();
					indexList.removeLast();
				}
			}
		}
		return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlidingWindowMaximum t = new SlidingWindowMaximum();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		nums = t.maxSlidingWindow(nums, 3);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}

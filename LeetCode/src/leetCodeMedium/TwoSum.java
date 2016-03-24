package leetCodeMedium;

import java.util.Arrays;
import java.util.Comparator;
//import java.util.HashMap;
//import java.util.Map;

/**
 * @author Poirot 2015年8月22日
 */
public class TwoSum {
//	public int[] twoSum(int[] nums, int target) {
//		// solution use map
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			Integer index1 = map.get(target - nums[i]);
//			if (index1 != null) {
//				return new int[] { index1, i + 1 };
//			}
//			map.put(nums[i], i + 1);
//		}
//		return null;
//	}

	class Node {
		int index;
		int value;

		Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		Node[] temp = new Node[nums.length];
		for (int i = 0; i < nums.length; i++) {
			temp[i] = new Node(i, nums[i]);
		}
		Arrays.sort(temp, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.value - o2.value;
			}
		});
		int startIndex = 0;
		int endIndex = temp.length - 1;
		while (startIndex < endIndex) {
			if (temp[startIndex].value + temp[endIndex].value < target) {
				startIndex++;
			} else if (temp[startIndex].value + temp[endIndex].value > target) {
				endIndex--;
			} else {
				res[0] = Math.min(temp[startIndex].index, temp[endIndex].index) + 1;
				res[1] = Math.max(temp[startIndex].index, temp[endIndex].index) + 1;
				return res;
			}
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

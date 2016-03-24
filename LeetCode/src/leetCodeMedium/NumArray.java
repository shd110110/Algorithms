package leetCodeMedium;
 

/**
 * @author Poirot 2015年11月18日
 */
public class NumArray {

	// time limited Exceeded
	// int[] sums;
	// int[] nums;
	// TreeMap<Integer, Integer> map = new TreeMap<>();
	// public NumArray(int[] nums) {
	// this.nums = nums;
	// sums = new int[nums.length];
	// int tempSum = 0;
	// for (int i = 0; i < nums.length; i++) {
	// tempSum += nums[i];
	// sums[i] = tempSum;
	// }
	// }
	//
	// void update(int i, int val) {
	// int x = 0;
	// if (i == 0) {
	// x = sums[i];
	// } else {
	// x = sums[i] - sums[i-1];
	// }
	// int change = val - x;
	// if (map.containsKey(i)) {
	// map.put(i, map.get(i) + change);
	// } else {
	// map.put(i, change);
	// }
	// }
	//
	// public int sumRange(int i, int j) {
	// int res = 0;
	// if (i == 0) {
	// res = sums[j];
	// } else {
	// res = sums[j] - sums[i-1];
	// }
	// if (map.size() > sums.length) {
	// for (Integer key : map.keySet()) {
	// nums[key] += map.get(key);
	// if (key >= i && key <= j) {
	// res += map.get(key);
	// }
	// map.remove(key);
	// }
	// int tempSum = 0;
	// for (int k = 0; k < nums.length; k++) {
	// tempSum += nums[k];
	// sums[k] = tempSum;
	// }
	//
	// } else {
	// for (Integer key : map.keySet()) {
	// if (key >= i && key <= j) {
	// res += map.get(key);
	// }
	// }
	// }
	//
	// return res;
	// }

	class SegmentTreeNode {
		int start, end;
		SegmentTreeNode left, right;
		int sum;

		public SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
			this.left = null;
			this.right = null;
			this.sum = 0;
		}
	}

	SegmentTreeNode root = null;

	public NumArray(int[] nums) {
		root = buildTree(nums, 0, nums.length - 1);
	}

	private SegmentTreeNode buildTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		} else {
			SegmentTreeNode ret = new SegmentTreeNode(start, end);
			if (start == end) {
				ret.sum = nums[start];
			} else {
				int mid = start + (end - start) / 2;
				ret.left = buildTree(nums, start, mid);
				ret.right = buildTree(nums, mid + 1, end);
				ret.sum = ret.left.sum + ret.right.sum;
			}
			return ret;
		}
	}

	void update(int i, int val) {
		update(root, i, val);
	}

	void update(SegmentTreeNode root, int pos, int val) {
		if (root.start == root.end) {
			root.sum = val;
		} else {
			int mid = root.start + (root.end - root.start) / 2;
			if (pos <= mid) {
				update(root.left, pos, val);
			} else {
				update(root.right, pos, val);
			}
			root.sum = root.left.sum + root.right.sum;
		}
	}

	public int sumRange(int i, int j) {
		return sumRange(root, i, j);
	}

	public int sumRange(SegmentTreeNode root, int start, int end) {
		if (root.end == end && root.start == start) {
			return root.sum;
		} else {
			int mid = root.start + (root.end - root.start) / 2;
			if (end <= mid) {
				return sumRange(root.left, start, end);
			} else if (start >= mid + 1) {
				return sumRange(root.right, start, end);
			} else {
				return sumRange(root.right, mid + 1, end) + sumRange(root.left, start, mid);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
